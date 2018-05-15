import extend.Cycle
import extend.Extender
import extend.verify
import search.Pathfinder
import search.SquareGraph
import util.SquareCache
import util.Verifier

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val startTime = System.currentTimeMillis()

//        graphSearch(10_000)
        extender(10_000)

        println("time in seconds: ${(System.currentTimeMillis() - startTime) / 1000}")
    }

    private fun graphSearch(max_vertex_number: Int) {
        val squareCache = SquareCache(2* max_vertex_number)
        for (number in 32..max_vertex_number) {
            val graph = SquareGraph(number)
            var done = false
            var searchDurationMs = 1
            while (!done) {
                searchDurationMs *= 2
                val solution = Pathfinder(graph).search(searchDurationMs.toLong())
                val verified = !solution.isEmpty() && Verifier(solution, squareCache).isHamiltonianCycle(number)
                done = verified || searchDurationMs >= 1000
                if (done) {
                    print("$number ")
//                    println(solution)
                    if (number % 10 == 0) println()
                    if (!verified) throw IllegalStateException("no solution found for number $number")
                }
            }
        }
    }

    private fun extender(max_vertex_number: Int) {
        val solution50 = listOf(
                2, 47, 34, 30, 19, 45, 36, 28, 21, 43, 38, 26, 23, 41, 40, 24, 25, 39, 42, 22, 27, 37, 44, 20, 29,
                35, 46, 18, 31, 50, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 49, 32, 17, 8, 1, 48, 33, 16, 9, 7)

        val startingCycle = Cycle(50, solution50)
        println(if (startingCycle.verify()) "verified!" else "error")

        val squares = SquareCache(2 * max_vertex_number)
        var cycle = startingCycle
        while(cycle.maxNumber < max_vertex_number) {
            cycle = Extender(squares).extendCycle(cycle)
            print("${cycle.maxNumber} ")
//            println(cycle)
            if (cycle.maxNumber % 10 == 0) println()
            if (!cycle.verify(squares)) throw RuntimeException("verify error for ${cycle.maxNumber}")
        }

    }

}
