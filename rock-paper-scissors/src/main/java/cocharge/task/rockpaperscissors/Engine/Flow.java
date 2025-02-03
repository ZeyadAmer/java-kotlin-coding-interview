package cocharge.task.rockpaperscissors.Engine;

import cocharge.task.rockpaperscissors.model.Player;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Flow {
    public ArrayList<Player> players;
    public Flow() {
        players = new ArrayList<>();
    }
    public void homePage(ArrayList<Player> players) {
        this.players = players;
        int userChoice = 0;
        Scanner userInput = new Scanner(System.in);
        boolean userModeChosen = false;
        System.out.println("Hello, \n" +
                "Welcome to Rock Paper Scissors demo \n"+
                "Please choose the preferred mode");
        System.out.println("1- Minimal Requirement \n" +
                "2- Single Player (against computer)\n"+
                "3- Decider (two players and the game randomly picks for each one and decides the winner)");
        while(!userModeChosen) {
            try{
                userChoice = userInput.nextInt();
                if (userChoice == 1) {
                    userModeChosen = true;

                } else if (userChoice == 2) {
                    userModeChosen = true;

                } else if (userChoice == 3) {
                    userModeChosen = true;

                } else {
                    System.out.println("Please choose 1 or 2");
                }

            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n +" +
                        "Please enter one of the numbers provided (1,2,3).");
                userInput.next();
            }

        }
    }
}
