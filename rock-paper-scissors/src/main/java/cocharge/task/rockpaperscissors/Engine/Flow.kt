package cocharge.task.rockpaperscissors.Engine;

import cocharge.task.rockpaperscissors.model.Modes;
import cocharge.task.rockpaperscissors.model.Player;
import cocharge.task.rockpaperscissors.service.GameModes;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Flow {
    public ArrayList<Player> players;
    public void startGame() throws InterruptedException {
        players = new ArrayList<>();
        GameModes gameModes = new GameModes();
        int userChoice = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello,\n"+
                "Welcome to Rock Paper Scissors demo\n"+
                "Please enter your name");
        String name = userInput.nextLine();
        Player player1 = new Player();
        player1.setName(name);
        players.add(player1);
        System.out.println("Hi " + player1.getName() + "\n");
        Thread.sleep(1000);
        homeOptionsPrint();
        while(true) {
            try{
                userChoice = userInput.nextInt();
                 if (validateChoice(userChoice)) {
                     Modes mode = Modes.fromInt(userChoice);
                     if(mode == null){
                         System.out.println("Thank you for playing \nHope you enjoyed!!!.");
                         break;
                     }
                     gameModes.GameMode(players, mode);
                     homeOptionsPrint();
                }else {
                    System.out.println("Please enter one of the numbers provided (1,2,3,4).");
                }

            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n" +
                        "Please enter one of the numbers provided (1,2,3,4).");
                userInput.next();
            }
        }

    }
    private void homeOptionsPrint(){
        System.out.println("Please choose the preferred mode\n"+
                "1- Minimal Requirement\n"+
                "2- Single Player (against computer)\n"+
                "3- Decider (two players and the game randomly picks for each one and decides the winner) \n"+
                "4- Quit the game");
    }
    private boolean validateChoice(int userChoice){
        return userChoice <= 4 && userChoice >= 1;
    }
}
