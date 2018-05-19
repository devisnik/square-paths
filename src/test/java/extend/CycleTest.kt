package extend

import org.junit.Assert
import org.junit.Test

private val solution32 = listOf(
        1, 15, 10, 26, 23, 2, 14, 22, 27, 9, 16, 20, 29, 7, 18, 31, 5, 11, 25, 24, 12, 13, 3, 6, 30, 19,
        17, 32, 4, 21, 28, 8)

private val brokenCycle32 = listOf(
        1, 15, 10, 26, 23, 2, 14, 22, 9, 27, 16, 20, 29, 7, 18, 31, 5, 11, 25, 24, 12, 13, 3, 6, 30, 19,
        17, 32, 4, 21, 28, 8)

class CycleTest {

    @Test
    fun `verifies hamiltonian cycle`() {
        val cycle = cycleOf(solution32)

        Assert.assertEquals(true, cycle.isHamiltonian())
    }

    @Test
    fun `verifies non-hamiltonian cycle when adding single node`() {
        val cycle = Cycle(solution32.size + 1, solution32.toIntArray())

        Assert.assertEquals(false, cycle.isHamiltonian())
    }

    @Test
    fun `fails on non-square edge`() {
        val cycle = cycleOf(brokenCycle32)

        Assert.assertEquals(false, cycle.isHamiltonian())
    }

    @Test
    fun `fails on hamiltonian path with 15 nodes`() {
        val cycle = cycleOf(listOf(9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8))

        Assert.assertEquals(false, cycle.isHamiltonian())
    }

    @Test
    fun `inserts a node into an edge`() {
        val cycle = cycleOf(listOf(1, 2, 3, 4)).withNewNode()
        cycle.replace(2 to 3, 5 to 5)

        Assert.assertEquals(listOf(1, 2, 5, 3, 4), cycle.toList().toList())
    }

    @Test
    fun `replace a segment with another one`() {
        val cycle = cycleOf(listOf(1, 2, 3, 4, 5)).withNewNode()
        val cut = cycle.replace(2 to 5, 6 to 6)
        cycle.replace(1 to 2, cut!!)

        Assert.assertEquals(listOf(1, 3, 4, 2, 6, 5), cycle.toList().toList())
    }

    @Test
    fun `replace a segment with another one faster`() {
        val cycle = cycleOf(listOf(1, 2, 3, 4, 5, 6)).withNewNode()
        val cut = cycle.replace(2 to 5, 7 to 7, false)

        Assert.assertEquals(listOf(1, 2, 7, 5, 6), cycle.toList().toList())
        Assert.assertEquals(3 to 4, cut)
    }

    @Test
    fun `replace a segment with a reversed other faster`() {
        val cycle = cycleOf(listOf(1, 2, 3, 4, 5, 6)).withNewNode()
        cycle.replace(2 to 5, 7 to 7, false)
        val cut = cycle.replace(1 to 2, 3 to 4, true)
        Assert.assertEquals(listOf(1, 4, 3, 2, 7, 5, 6), cycle.toList().toList())
        Assert.assertEquals(null, cut)
    }

    @Test
    fun `inserts a node into an edge faster`() {
        val cycle = cycleOf(listOf(1, 2, 3, 4)).withNewNode()
        val cut = cycle.replace(2 to 3, 5 to 5, false)

        Assert.assertEquals(listOf(1, 2, 5, 3, 4), cycle.toList().toList())
        Assert.assertEquals(null, cut)
    }

    @Test
    fun `cycles to first beyond last node`() {
        val cycle = cycleOf(listOf(1, 2, 3, 4, 5)).withNewNode()
        cycle.replace(4 to 2, 6 to 6)

        Assert.assertEquals(listOf(2, 3, 4, 6), cycle.toList(2).toList())
    }
}
