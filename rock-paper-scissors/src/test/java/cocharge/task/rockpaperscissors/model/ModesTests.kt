package cocharge.task.rockpaperscissors.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ModesTests {
    @Test
    void testFromInt_ValidInputs() {
        assertEquals(Modes.MinimalRequirement, Modes.fromInt(1));
        assertEquals(Modes.SingePlayer, Modes.fromInt(2));
        assertEquals(Modes.Decider, Modes.fromInt(3));
    }

    @Test
    void testFromInt_InvalidInput() {
        assertNull(Modes.fromInt(0));
        assertNull(Modes.fromInt(4));
        assertNull(Modes.fromInt(-1));
    }

    @Test
    void testFromInt_BoundaryInputs() {
        assertNull(Modes.fromInt(Integer.MAX_VALUE));
        assertNull(Modes.fromInt(Integer.MIN_VALUE));
    }
}
