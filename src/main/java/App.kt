import extend.CutAndInsertExtender
import extend.Cycle
import extend.GerbiczExtender
import search.Pathfinder
import search.SquareGraph
import util.*

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val startTime = System.currentTimeMillis()

        extendLoop(20_001, graphSearch(299)!!)

        println("time in seconds: ${(System.currentTimeMillis() - startTime) / 1000}")
    }

    private fun extendLoop(max_vertex_number: Int, starter: Cycle) {
        println(
                if (starter.isHamiltonian())
                    "starter of size ${starter.maxNumber} verified!"
                else
                    throw RuntimeException("invalid starter of size ${starter.maxNumber}")
        )

        var cycle = starter
        while (cycle.maxNumber < max_vertex_number) {
            cycle = extend(cycle) ?: throw IllegalStateException("no extension found!")
            print("${cycle.maxNumber.toString().padStart(6, '>')} ")
            println(cycle)
            when {
                cycle.isHamiltonian().not() -> throw RuntimeException("verify error for ${cycle.maxNumber}")
                cycle.maxNumber % 10 == 0 -> println()
                cycle.maxNumber % 10_000 == 0 -> persist(cycle)
            }
        }
    }

    private fun graphSearch(number: Int): Cycle? {
        val graph = SquareGraph(number)
        var done = false
        var searchDurationMs = 1
        while (!done) {
            searchDurationMs *= 2
            val solution = Pathfinder(graph).search(searchDurationMs.toLong())
            val verified = !solution.isEmpty() && Verifier(solution, squareCache).isHamiltonianCycle(number)
            done = verified || searchDurationMs >= 1000
            if (done) {
                return Cycle(number, solution.toIntArray())
            }
        }
        return null
    }

    private fun extend(extendee: Cycle): Cycle? =
            GerbiczExtender.extend(extendee)
                    ?: CutAndInsertExtender.extend(extendee)
                    ?: graphSearch(extendee.maxNumber + 1)

    private fun persist(cycle: Cycle) {
        try {
            writeSolutionToFile("solution_${cycle.maxNumber}.txt", cycle.toList())
        } catch (e: Exception) {
            println(e.message)
        }
    }

}
