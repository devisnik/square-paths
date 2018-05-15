package search

import util.Edges

class Path(private val number: Int) {

    private val nodes: IntArray = IntArray(number)
    private val included: BooleanArray = BooleanArray(number)
    private var currentTop = -1

    val isHamiltonian: Boolean
        get() = currentTop == number - 1

    fun append(node: Int) {
        if (included[node - 1])
            throw IllegalStateException("vertex already in path: $node")
        currentTop += 1
        nodes[currentTop] = node
        included[node - 1] = true
    }

    fun removeLast() {
        val node = nodes[currentTop]
        included[node - 1] = false
        currentTop -= 1
    }

    fun last(): Int = nodes[currentTop]

    fun canBeClosed(): Boolean = Edges.isSquare(nodes[0], nodes[currentTop])

    fun length(): Int = currentTop + 1

    operator fun contains(neighbor: Int): Boolean = included[neighbor - 1]

    fun toList(): List<Int> = nodes.toList()
}
