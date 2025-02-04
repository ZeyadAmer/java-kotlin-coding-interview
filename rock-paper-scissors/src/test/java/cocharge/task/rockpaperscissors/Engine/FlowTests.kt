package cocharge.task.rockpaperscissors.Engine;

import cocharge.task.rockpaperscissors.model.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FlowTests {

    @Test
    void testQuitGame() throws InterruptedException {
        String simulatedInput = "Player1\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Flow flow = new Flow();
        flow.startGame();

        assertEquals(1, flow.players.size());
        assertEquals("Player1", flow.players.get(0).getName());
    }

}
