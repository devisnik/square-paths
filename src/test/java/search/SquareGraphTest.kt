package search

import org.junit.Assert
import org.junit.Test

class SquareGraphTest {

    @Test
    fun `creates Graph`() {
        SquareGraph(15)
    }

    @Test
    fun `knows Edges For Node`() {
        val graph = SquareGraph(15)

        Assert.assertArrayEquals(intArrayOf(15, 8, 3), graph.getNeighbors(1))
        Assert.assertArrayEquals(intArrayOf(9, 2), graph.getNeighbors(7))
        Assert.assertArrayEquals(intArrayOf(7), graph.getNeighbors(9))
        Assert.assertArrayEquals(intArrayOf(10, 1), graph.getNeighbors(15))
    }

    @Test
    fun `knows Degree Of Vertex`() {
        val graph = SquareGraph(15)

        Assert.assertEquals(3, graph.degree(1).toLong())
        Assert.assertEquals(1, graph.degree(9).toLong())
        Assert.assertEquals(2, graph.degree(15).toLong())
    }
}
