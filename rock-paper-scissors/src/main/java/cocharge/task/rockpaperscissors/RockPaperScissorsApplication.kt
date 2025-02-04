package cocharge.task.rockpaperscissors;

import cocharge.task.rockpaperscissors.Engine.Flow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RockPaperScissorsApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RockPaperScissorsApplication.class, args);
        Flow gameFlow = new Flow();
        gameFlow.startGame();
    }

}
