package cocharge.task.rockpaperscissors.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RockPaperScissorsTests {
    @Test
    void testFromInt_ValidInputs() {
        assertEquals(RockPaperScissors.ROCK, RockPaperScissors.fromInt(1));
        assertEquals(RockPaperScissors.PAPER, RockPaperScissors.fromInt(2));
        assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.fromInt(3));
    }

    @Test
    void testFromInt_InvalidInput() {
        assertNull(RockPaperScissors.fromInt(0));
        assertNull(RockPaperScissors.fromInt(4));
        assertNull(RockPaperScissors.fromInt(-1));
    }

    @Test
    void testFromInt_BoundaryInputs() {
        assertNull(RockPaperScissors.fromInt(Integer.MAX_VALUE));
        assertNull(RockPaperScissors.fromInt(Integer.MIN_VALUE));
    }
}
