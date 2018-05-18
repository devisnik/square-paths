package extend

import util.SquareCache
import util.squareCache

fun cycleOf(edgeList: List<Int>) = Cycle(edgeList.size, edgeList.toIntArray())

class Cycle private constructor(
        val maxNumber: Int,
        private val squares: SquareCache,
        private val edgeList: IntArray
) {

    constructor(maxNumber: Int, nodes: IntArray, squares: SquareCache = squareCache) :
            this(maxNumber, squares, IntArray(maxNumber + 1) { _ -> -1 })
    {
        nodes.forEachIndexed { index, node ->
            edgeList[node] = nodes[(index + 1) % nodes.size]
        }
    }

    fun withNewNode() : Cycle = Cycle(maxNumber+1, squares, edgeList + intArrayOf(-1))

    private fun cut(from: Int, to: Int): List<Int> {
        val cutout = arrayListOf<Int>()
        var node = from
        while (edgeList[node] != to) {
            val target = edgeList[node]
            cutout += target
            edgeList[node] = -1
            node = target
        }
        edgeList[node] = -1
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
        val end = edgeList[start]
        val newEdges = listOf(start).plus(path).plus(end)
        (0 until newEdges.size - 1).forEach { index ->
            edgeList[newEdges[index]] = newEdges[index + 1]
        }
    }

    override fun toString() = toList().toList().toString()

    fun toList(): IntArray {
        val startNode = (0 until edgeList.size).first { edgeList[it] != -1 }
        val nodeList = IntArray(edgeList.size -1)
        var current = startNode
        var index = 0
        do {
            nodeList[index] = current
            index += 1
            current = edgeList[current]
        } while (current != startNode)
        return nodeList.sliceArray(0 until index) // cut off trailing zeros for non-hamiltonian cycles
    }

    fun isHamiltonian(): Boolean {
        val startNode = (0 until edgeList.size).first { edgeList[it] != -1 }
        val nodeList = BooleanArray(edgeList.size)
        var current = startNode
        var edgeCount = 0
        do {
            if (nodeList[current]) return false
            nodeList[current] = true
            if (!squares.contains(current + edgeList[current])) return false
            edgeCount += 1
            current = edgeList[current]
            if (current == -1) throw IllegalStateException("not in cycle!")
        } while (current != startNode)
        return edgeCount == maxNumber

    }

    fun next(node: Int) = edgeList[node]
}
