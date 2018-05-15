package extend

import util.SquareCache

class Extender(private val squareCache: SquareCache) {

    private inline fun cutouts(source: List<Int>): Sequence<Pair<Int, Int>> {
        var distance = 1
        var startIndex = 0
        val max = source.size
        return generateSequence {
            if (distance > max / 2) return@generateSequence null
            val pair = Pair(source[startIndex], source[(startIndex + distance) % max])
            startIndex += 1
            if (startIndex == max) {
                startIndex = 0
                distance += 1
            }
            return@generateSequence pair
        }
    }

    private inline fun extensions(source: List<Int>, extendee: List<Int>): Sequence<Pair<Pair<Int, Int>, List<Int>>> =
            cutouts(source)
                    .filter { p ->
                        val firstExtendee = extendee.first()
                        val lastExtendee = extendee.last()
                        isSquare(p.first, firstExtendee) && isSquare(p.second, lastExtendee)
                                || isSquare(p.first, lastExtendee) && isSquare(p.second, firstExtendee)
                    }
                    .map { p ->
                        if (isSquare(p.first, extendee.first()) && isSquare(p.second, extendee.last()))
                            Pair(p, extendee)
                        else
                            Pair(p, extendee.reversed())
                    }

    private inline fun isSquare(left: Int, right: Int): Boolean = squareCache.contains(left + right)

    fun extendCycle(extendee: Cycle): Cycle {
        val forbidden: MutableList<Pair<Int, Int>> = mutableListOf()
        var ext: List<Int> = listOf(extendee.maxNumber + 1)
        val cycle = Cycle(extendee.maxNumber + 1, extendee.toList())
        var count = 0
        while (ext.isNotEmpty()) {
//        println("forbidden: $forbidden")
//        println("current cycle ${cycle.toList()}")
            val (pair, list) = extensions(cycle.toList(), ext)
                    .filterNot { e -> forbidden.contains(e.first) }
                    .first()
//        println("${pair}: ${pair.distance(cycle)} $list")
            forbidden += arrayOf(pair, pair.reversed())
            ext = cycle.replace(pair, list)
//        println(ext)
            count++
        }
//        println(count)
        return cycle
    }

    private inline fun Pair<Int, Int>.reversed() = Pair(this.second, this.first)
}
