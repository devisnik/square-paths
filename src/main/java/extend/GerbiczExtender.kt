package extend

import util.squareCache

// see http://www.mersenneforum.org/showpost.php?s=b2d1b7da337e837bfe622060c950c7a5&p=477406&postcount=9
object GerbiczExtender {

    private inline fun isSquare(number: Int) = squareCache.contains(number)

    private fun indexPairs() = generateSequence(Pair(0, 1)) {
        if (it.first + 1 == it.second)
            Pair(0, it.second + 1)
        else
            Pair(it.first + 1, it.second)
    }

    private fun squaresIn(range: IntRange): List<Int> {
        return range.filter(::isSquare)
    }

    private fun squareExtenders(number: Int): Sequence<Pair<Int, Int>> {
        val squares = squaresIn(number + 1 until 2 * number)
        return indexPairs()
                .takeWhile { it.second < squares.size }
                .flatMap { (a, b) -> sequenceOf(a to b, b to a) }
                .map { (a, b) -> squares[a] to squares[b] }
    }

    fun cycleExtenders(cycle: Cycle): Sequence<Pair<Int, Int>> {
        val n = cycle.maxNumber + 1
        return squareExtenders(n)
                .map { (s1, s2) -> (s1 - n) to (s2 - n) }
                .filter { (v1, v2) ->
                    isSquare(cycle.next(v1) + cycle.next(v2))
                }
    }

    fun extend(extendee: Cycle): Cycle? {
        val cycle = extendee.withNewNode()
        val edge = cycleExtenders(extendee).firstOrNull() ?: return null
        val cut = cycle.replace(edge, Pair(extendee.maxNumber + 1, extendee.maxNumber + 1), false)
        if (cut != null) cycle.replace(edge.second to cycle.next(edge.second), cut, true)
        return cycle
    }
}
