package search

import java.time.Instant
import java.util.Collections

class Pathfinder(private val graph: SquareGraph) {

    private lateinit var endTime: Instant

    fun search(searchDurationPerVertexInMs: Long): List<Int> {
        for (vertex in 1..graph.number) {

            // we give up for each vertex after some short time period,
            // turns out it is long enough for some vertex eventually
            endTime = Instant.now().plusMillis(searchDurationPerVertexInMs)

            val path = Path(graph.number)
            path.append(vertex)
            if (extend(path))
                return path.toList()
        }
        return emptyList()
    }

    private fun extend(path: Path): Boolean {
        if (path.isHamiltonian && path.canBeClosed()) {
            return true
        }

        if (Instant.now().isAfter(endTime)) return false

        for (neighbor in graph.getNeighbors(path.last())) {
            if (path.contains(neighbor)) continue
            path.append(neighbor)
            if (extend(path)) {
                return true
            } else {
                path.removeLast()
            }
        }
        return false
    }

}
