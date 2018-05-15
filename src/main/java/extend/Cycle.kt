package extend

class Cycle(val maxNumber: Int, nodes: List<Int>) {

    private val edgeList = MutableList<Int?>(maxNumber + 1) { _ -> null }

    init {
        nodes.forEachIndexed { index, node ->
            addEdge(node, nodes[(index + 1) % nodes.size])
        }
    }

    private fun addEdge(edge: Pair<Int, Int?>) {
        edgeList[edge.first] = edge.second
    }

    private fun addEdge(from: Int, to: Int?) {
        addEdge(Pair(from, to))
    }

    private fun cut(from: Int, to: Int): List<Int> {
        val cutout = arrayListOf<Int>()
        var node = from
        while (edgeList[node] != to) {
            val target = edgeList[node]!!
            cutout += target
            edgeList[node] = null
            node = target
        }
        edgeList[node] = null
        edgeList[from] = to
        return cutout
    }

    private fun replace(from: Int, to: Int, path: List<Int>): List<Int> {
        val cut = cut(from, to)
        insertAt(from, path)
        return cut
    }

    fun replace(edge: Pair<Int, Int>, path: List<Int>) = replace(edge.first, edge.second, path)

    private fun insertAt(start: Int, path: List<Int>) {
        val end = edgeList[start]!!
        val newEdges = listOf(start).plus(path).plus(end)
        (0 until newEdges.size - 1).forEach { index ->
            edgeList[newEdges[index]] = newEdges[index + 1]
        }
    }

    override fun toString() = toList().toString()

    fun toList(): List<Int> {
        val startNode = (0 until edgeList.size).first { edgeList[it] != null }
        val nodeList = ArrayList<Int>(edgeList.size)
        var current = startNode
        do {
            nodeList.add(current)
            current = edgeList[current]!!
        } while (current != startNode)
        return nodeList
    }

    fun distance(edge: Pair<Int, Int>): Int {
        var current = edge.first
        var count = 0
        while (current != edge.second) {
            count++
            current = edgeList[current]!!
        }
        return count
    }
}
