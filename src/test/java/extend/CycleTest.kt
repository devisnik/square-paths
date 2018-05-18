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


}
