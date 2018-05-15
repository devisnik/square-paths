package extend

import util.SquareCache
import util.Verifier

val solution32 = listOf(
        1, 15, 10, 26, 23, 2, 14, 22, 27, 9, 16, 20, 29, 7, 18, 31, 5, 11, 25, 24, 12, 13, 3, 6, 30, 19,
        17, 32, 4, 21, 28, 8)

val solution50 = listOf(
        2, 47, 34, 30, 19, 45, 36, 28, 21, 43, 38, 26, 23, 41, 40, 24, 25, 39, 42, 22, 27, 37, 44, 20, 29,
        35, 46, 18, 31, 50, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 49, 32, 17, 8, 1, 48, 33, 16, 9, 7)

val solution100 = listOf(
        63, 81, 88, 56, 65, 79, 90, 54, 67, 77, 92, 52, 69, 100, 96, 73, 71, 98, 46, 75, 94, 50, 31, 33,
        48, 16, 84, 85, 59, 62, 82, 87, 57, 64, 80, 89, 55, 66, 78, 91, 53, 68, 76, 93, 51, 70, 99, 97,
        72, 49, 95, 74, 47, 34, 30, 19, 45, 36, 28, 21, 60, 61, 83, 86, 58, 42, 39, 25, 24, 40, 41, 8, 17,
        32, 4, 5, 11, 38, 43, 6, 3, 13, 12, 37, 44, 20, 29, 35, 1, 15, 10, 26, 23, 2, 14, 22, 27, 9, 7, 18)

val solution132 = listOf(
        37, 132, 12, 109, 116, 80, 89, 107, 118, 78, 91, 105, 120, 76, 93, 103, 122, 74, 95, 130, 126,
        99, 97, 128, 68, 101, 124, 72, 49, 51, 70, 30, 114, 111, 85, 84, 112, 113, 83, 86, 110, 115,
        81, 88, 108, 117, 79, 90, 106, 119, 77, 92, 104, 121, 75, 94, 131, 125, 100, 96, 129, 127,
        98, 71, 73, 123, 102, 67, 54, 46, 35, 65, 56, 44, 20, 61, 60, 40, 41, 59, 62, 82, 87, 57, 64,
        36, 45, 55, 66, 34, 15, 21, 43, 38, 26, 10, 39, 42, 58, 6, 19, 17, 32, 4, 5, 11, 25, 24, 1,
        8, 28, 53, 47, 2, 23, 13, 3, 33, 48, 16, 9, 27, 22, 14, 50, 31, 69, 52, 29, 7, 18, 63)

fun main(args: Array<String>) {

    val cycle = Cycle(50, solution50)
    println(if (cycle.verify()) "verified!" else "error")

    val startTime = System.currentTimeMillis()

    val squares = SquareCache(1_000_000)
    var cyc = cycle
    (1..100).forEach {
        cyc = Extender(squares).extendCycle(cyc)
//        if (it % 1000 == 0) println("${cyc.maxNumber}")
        println("${cyc.maxNumber}: $cyc")
        if (!cyc.verify(squares)) throw RuntimeException("verify error for ${cyc.maxNumber}")
    }

    println("time in seconds: ${(System.currentTimeMillis() - startTime) / 1000}")
}

fun Cycle.verify(squareCache: SquareCache) = Verifier(toList(), squareCache).isHamiltonianCycle(maxNumber)
fun Cycle.verify() = Verifier(toList(), SquareCache(2 * maxNumber)).isHamiltonianCycle(maxNumber)
