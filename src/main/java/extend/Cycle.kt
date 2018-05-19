package extend

import util.SquareCache
import util.squareCache

fun cycleOf(edgeList: List<Int>) = Cycle(edgeList.size, edgeList.toIntArray())
fun cycleOf(edgeList: IntArray) = Cycle(edgeList.size, edgeList)

class Cycle private constructor(
        val maxNumber: Int,
        private val squares: SquareCache,
        private val edgeList: IntArray
) {

    constructor(maxNumber: Int, nodes: IntArray, squares: SquareCache = squareCache) :
            this(maxNumber, squares, IntArray(maxNumber + 1) { _ -> -1 }) {
        nodes.forEachIndexed { index, node ->
            edgeList[node] = nodes[(index + 1) % nodes.size]
        }
    }

    fun withNewNode(): Cycle = Cycle(maxNumber + 1, squares, edgeList + intArrayOf(-1))

    private fun cut(from: Int, to: Int): Pair<Int, Int>? {
        val start = next(from)
        if (start == to) return null
        var node = from
        while (edgeList[node] != to) {
            val target = edgeList[node]
            node = target
        }
        edgeList[node] = -1
        edgeList[from] = to
        return start to node
    }

    fun replace(edge: Pair<Int, Int>, segment: Pair<Int, Int>, reversed: Boolean = false): Pair<Int, Int>? {
        val cut = cut(edge.first, edge.second)
        if (reversed) {
            reverse(segment)
            edgeList[edge.first] = segment.second
            edgeList[segment.first] = edge.second
        } else {
            edgeList[edge.first] = segment.first
            edgeList[segment.second] = edge.second
        }
        return cut
    }

    private fun reverse(segment: Pair<Int, Int>) {
        if (segment.first == segment.second) return
        var current = segment.first
        var next = next(current)
        while (current != segment.second) {
            val previous = current
            current = next
            next = next(current)
            edgeList[current] = previous
        }
    }

    override fun toString() = toList().toList().toString()

    fun toList(startNode: Int = 1): IntArray {
        val nodeList = IntArray(edgeList.size - 1)
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
