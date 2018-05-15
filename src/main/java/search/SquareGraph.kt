package search

import util.Edges

import java.util.stream.IntStream

class SquareGraph(val number: Int) {

    private val edges: Array<IntArray> = Array(number) { vertex ->
        (1..number)
                .map { v -> number - v }
                .filter { v -> v != vertex }
                .filter { v -> isSquare(vertex, v) }
                .map { v -> v + 1 }
                .toIntArray()
    }

    private fun isSquare(vertex: Int, candidate: Int) = Edges.isSquare(vertex + 1, candidate + 1)

    fun getNeighbors(vertex: Int): IntArray = edges[vertex - 1]

    fun degree(vertex: Int): Int = edges[vertex - 1].size
}
