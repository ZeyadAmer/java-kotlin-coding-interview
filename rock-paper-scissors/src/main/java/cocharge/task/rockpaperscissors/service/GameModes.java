package cocharge.task.rockpaperscissors.service;

import cocharge.task.rockpaperscissors.model.Modes;
import cocharge.task.rockpaperscissors.model.Player;
import cocharge.task.rockpaperscissors.model.RockPaperScissors;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameModes {
    int rounds;
    int userChoice = 0;
    int tie;

    Scanner userInput;
    public void GameMode(ArrayList<Player> players, Modes mode) throws InterruptedException {
        this.userInput = new Scanner(System.in);
        this.rounds = 0;
        switch (mode) {
            case MinimalRequirement:
                minimalRequirements(players);
                break;
            case SingePlayer:
                singlePlayer(players);
                break;
            case Decider:
                Decider(players);
                break;
            default:
                return;
        }
    }
    private void minimalRequirements(ArrayList<Player> players) throws InterruptedException {
        tie = 0;
        Player ai = new Player("ai",0);
        players.add(ai);
        boolean backHome = false;
        while (!backHome) {
            for (int i = 0; i < 100; i++) {
                RockPaperScissors randomChoice = randomChoice();
                switch (randomChoice) {
                    case PAPER:
                        players.get(1).setScore(players.get(1).getScore() + 1);
                        break;
                    case SCISSORS:
                        players.get(0).setScore(players.get(0).getScore() + 1);
                        break;
                    case ROCK:
                        tie++;
                        break;
                }
            }
            backHome = score(players);
            players.get(0).setScore(0);
            players.get(1).setScore(0);
            tie = 0;
        }
        players.remove(1);
    }

    private void singlePlayer(ArrayList<Player> players) throws InterruptedException {
        boolean backHome = false;
        tie = 0;
        Player ai = new Player("ai",0);
        players.add(ai);
        while (!backHome) {
            RockPaperScissors randomChoice = randomChoice();
            RockPaperScissors userFighter = null;
            System.out.println("1- Rock \n2- Paper \n3- Scissors");
            try{
                userChoice = userInput.nextInt();
                while(true){
                    userFighter = RockPaperScissors.fromInt(userChoice);
                    if(userFighter != null){
                        break;
                    }
                    System.out.println("Please enter one of the numbers provided (1,2,3).");
                    userChoice = userInput.nextInt();
                }
            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n" +
                        "Please enter one of the numbers provided (1,2).");
                userInput.next();
                continue;
            }
            System.out.println("You chose: " + userFighter);
            System.out.println("The opponent chose: " + randomChoice + "\n");
            String result = determineWinner(userFighter, randomChoice);

            switch (result) {
                case "player1":
                    players.get(0).setScore(players.get(0).getScore() + 1);
                    break;
                case "player2":
                    players.get(1).setScore(players.get(1).getScore() + 1);
                    break;
                case "tie":
                    tie++;
                    break;
                default:
                    break;
            }
            backHome = score(players);
        }
        players.remove(1);

    }

    private void Decider(ArrayList<Player> players) throws InterruptedException {
        boolean backHome = false;
        tie = 0;
        System.out.println("Please enter player 2 name");
        String name = userInput.nextLine();
        Player player2 = new Player(name,0);
        players.add(player2);
        System.out.println("Hi " + player2.getName() + "\n");
        Thread.sleep(1000);
        while (!backHome) {
            RockPaperScissors player1Choice = randomChoice();
            RockPaperScissors player2Choice = randomChoice();

            System.out.println(players.get(0).getName() + " got: " + player1Choice);
            System.out.println(players.get(1).getName() + " got: " + player2Choice + "\n");
            String result = determineWinner(player1Choice, player2Choice);

            switch (result) {
                case "player1":
                    players.get(0).setScore(players.get(0).getScore() + 1);
                    break;
                case "player2":
                    players.get(1).setScore(players.get(1).getScore() + 1);
                    break;
                case "tie":
                    tie++;
                    break;
                default:
                    break;
            }

            backHome = score(players);
        }
        players.remove(1);

    }
    RockPaperScissors randomChoice() {
        Random random = new Random();
        int randomIndex = random.nextInt(RockPaperScissors.values().length);
        return RockPaperScissors.values()[randomIndex];
    }
    boolean score(ArrayList<Player> players) throws InterruptedException {
        System.out.println("Player " + players.get(0).getName() + " wins " + players.get(0).getScore() + "\n" +
                "Player " + players.get(1).getName() + " wins " + players.get(1).getScore() + "\n" +
                "Draws: " + tie + "\n");
        Thread.sleep(1000);
        System.out.println("do you want to play again or go back to main menu\n"+
                "1- play again\n"+
                "2- main menu");
        boolean validAnswer = false;
        while(!validAnswer){
            try{
                userChoice = userInput.nextInt();
                if (userChoice == 1)
                    validAnswer = true;
                else if (userChoice == 2) {
                    players.get(0).setScore(0);
                    return true;
                }else
                    System.out.println("Please enter one of the numbers provided (1,2).");


            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n" +
                        "Please enter one of the numbers provided (1,2).");
                userInput.next();
            }
        }
        return false;
    }
    static String determineWinner(RockPaperScissors playerChoice, RockPaperScissors opponentChoice) {
        if (playerChoice == opponentChoice) {
            return "tie";
        }

        switch (playerChoice) {
            case ROCK:
                return (opponentChoice == RockPaperScissors.SCISSORS) ? "player1" : "player2";
            case PAPER:
                return (opponentChoice == RockPaperScissors.ROCK) ? "player1" : "player2";
            case SCISSORS:
                return (opponentChoice == RockPaperScissors.PAPER) ? "player1" : "player2";
            default:
                return "Invalid choice.";
        }
    }
}
