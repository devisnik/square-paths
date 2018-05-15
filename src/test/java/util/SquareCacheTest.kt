package util

import org.junit.Assert.assertEquals
import org.junit.Test

class SquareCacheTest {

    @Test
    fun `contains small squares`() {
        val cache = SquareCache(20)

        listOf(1, 4, 9, 16).forEach {square ->
            assertEquals("$square is a square", true, cache.contains(square))
        }
    }

    @Test
    fun `handles square limit properly`() {
        val cache = SquareCache(25)

        listOf(1, 4, 9, 16).forEach {square ->
            assertEquals("$square is a square", true, cache.contains(square))
        }
        val cache26 = SquareCache(26)

        listOf(1, 4, 9, 16, 25).forEach {square ->
            assertEquals("$square is a square", true, cache26.contains(square))
        }
    }

    @Test
    fun `has correct number of squares`() {
        val cache = SquareCache(10_001)

        assertEquals(100, (1 until 10_001).map { cache.contains(it) }.filter { it }.count())
    }

}
