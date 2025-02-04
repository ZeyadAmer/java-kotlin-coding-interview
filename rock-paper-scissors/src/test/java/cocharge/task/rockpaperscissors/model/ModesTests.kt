package cocharge.task.rockpaperscissors.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ModesTests {

    @Test
    fun `test fromInt with valid inputs`() {
        assertEquals(Modes.MinimalRequirement, Modes.fromInt(1))
        assertEquals(Modes.SinglePlayer, Modes.fromInt(2))
        assertEquals(Modes.Decider, Modes.fromInt(3))
    }

    @Test
    fun `test fromInt with invalid input`() {
        assertNull(Modes.fromInt(0))
        assertNull(Modes.fromInt(4))
        assertNull(Modes.fromInt(-1))
    }

    @Test
    fun `test fromInt with boundary inputs`() {
        assertNull(Modes.fromInt(Int.MAX_VALUE))
        assertNull(Modes.fromInt(Int.MIN_VALUE))
    }
}
