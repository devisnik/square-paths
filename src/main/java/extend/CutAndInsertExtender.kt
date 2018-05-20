package extend

import util.squareCache

object CutAndInsertExtender {

    private inline fun cutouts(cycle: Cycle, startNode: Int): Sequence<Pair<Int, Int>> {
        var start = startNode
        var end = cycle.next(start)
        return generateSequence {
            if (start == end) return@generateSequence null
            val pair = Pair(start, end)
            start = cycle.next(start)
            end = cycle.next(end)
            if (start == startNode) {
                end = cycle.next(end)
            }
            return@generateSequence pair
        }
    }

    private inline fun extensions(cycle: Cycle, startNode: Int, extendee: Pair<Int, Int>): Sequence<Triple<Pair<Int, Int>, Pair<Int, Int>, Boolean>> =
            cutouts(cycle, startNode)
                    .filter { p ->
                        val firstExtendee = extendee.first
                        val lastExtendee = extendee.second
                        isSquare(p.first, firstExtendee) && isSquare(p.second, lastExtendee)
                                || isSquare(p.first, lastExtendee) && isSquare(p.second, firstExtendee)
                    }
                    .map { p ->
                        if (isSquare(p.first, extendee.first) && isSquare(p.second, extendee.second))
                            Triple(p, extendee, false)
                        else
                            Triple(p, extendee, true)
                    }

    private inline fun isSquare(left: Int, right: Int): Boolean = squareCache.contains(left + right)

    fun extend(extendee: Cycle): Cycle? {
        val forbidden: MutableList<Pair<Int, Int>> = mutableListOf()
        val cycle = extendee.withNewNode()
        var ext: Pair<Int, Int>? = Pair(cycle.maxNumber, cycle.maxNumber)
        var cycleStart = (1..cycle.maxNumber).first { squareCache.contains(it + cycle.maxNumber)}
        var count = 0
        while (ext != null) {
//        println("forbidden: $forbidden")
//        println("current cycle ${cycle.toList().toList()}")
            try {
                val (pair, segment, reverse) = extensions(cycle, cycleStart, ext)
                        .filterNot { e -> forbidden.contains(e.first) }
                        .first()
//        println("${pair}: ${pair.distance(cycle)} $list")
                forbidden += arrayOf(pair, pair.reversed())
                ext = cycle.replace(pair, segment, reverse)
                cycleStart = pair.second
//        println(ext)
                count++
            } catch (e: Exception) {
                return null
            }
        }
//        println(count)
        return cycle
    }

    private inline fun Pair<Int, Int>.reversed() = Pair(this.second, this.first)
}
