package util

class SquareCache(upperLimit: Int) {

    private val cache: BooleanArray = BooleanArray(upperLimit)

    init {
        (1..Math.sqrt(upperLimit.dec().toDouble()).toInt())
                .forEach { n -> cache[n * n] = true }
    }

    operator fun contains(i: Int): Boolean {
        return cache[i]
    }
}
