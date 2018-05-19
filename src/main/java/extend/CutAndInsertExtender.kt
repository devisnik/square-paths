package extend

import util.squareCache

object CutAndInsertExtender {

    private inline fun cutouts(source: IntArray): Sequence<Pair<Int, Int>> {
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

    private inline fun extensions(source: IntArray, extendee: List<Int>): Sequence<Pair<Pair<Int, Int>, List<Int>>> =
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

    private inline fun extensions(source: IntArray, extendee: Pair<Int, Int>): Sequence<Triple<Pair<Int, Int>, Pair<Int, Int>, Boolean>> =
            cutouts(source)
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
                val (pair, segment, reverse) = extensions(cycle.toList(cycleStart), ext)
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
