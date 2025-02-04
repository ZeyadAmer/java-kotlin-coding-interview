package cocharge.task.rockpaperscissors.model
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RockPaperScissorsTests {

    @Test
    fun `test fromInt with valid inputs`() {
        assertEquals(RockPaperScissors.ROCK, RockPaperScissors.fromInt(1))
        assertEquals(RockPaperScissors.PAPER, RockPaperScissors.fromInt(2))
        assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.fromInt(3))
    }

    @Test
    fun `test fromInt with invalid input`() {
        assertNull(RockPaperScissors.fromInt(0))
        assertNull(RockPaperScissors.fromInt(4))
        assertNull(RockPaperScissors.fromInt(-1))
    }

    @Test
    fun `test fromInt with boundary inputs`() {
        assertNull(RockPaperScissors.fromInt(Int.MAX_VALUE))
        assertNull(RockPaperScissors.fromInt(Int.MIN_VALUE))
    }
}
