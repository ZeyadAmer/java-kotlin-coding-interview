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
    Scanner userInput;
    Random random;
    public void GameMode(ArrayList<Player> players, Modes mode) throws InterruptedException {
        this.userInput = new Scanner(System.in);
        this.random = new Random();
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
        boolean backHome = false;
        while (!backHome) {
            for (int i = 0; i < 100; i++) {
                int randomIndex = random.nextInt(RockPaperScissors.values().length);
                RockPaperScissors randomChoice = RockPaperScissors.values()[randomIndex];
                switch (randomChoice) {
                    case PAPER:
                        players.get(1).setScore(players.get(1).getScore() + 1);
                        break;
                    case SCISSORS:
                        players.get(0).setScore(players.get(0).getScore() + 1);
                        break;
                    case ROCK:
                        break;
                }
            }
            System.out.println("Player " + players.get(0).getName() + " wins " + players.get(0).getScore() + " of 100 games\n" +
                    "Player " + players.get(1).getName() + " wins " + players.get(1).getScore() + " of 100 games\n" +
                    "Draws: " + (100 - players.get(1).getScore() - players.get(0).getScore()) + "\n");
            players.get(0).setScore(0);
            players.get(1).setScore(0);
            Thread.sleep(1000);
            System.out.println("do you want to play again or go back to main menu\n"+
                    "1- play again\n"+
                    "2- main menu");
            try{
                userChoice = userInput.nextInt();
                if (userChoice == 1){}
                else if (userChoice == 2)
                    backHome = true;
                else
                    System.out.println("Please enter one of the numbers provided (1,2).");


            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n" +
                        "Please enter one of the numbers provided (1,2).");
                userInput.next();
            }
        }
    }

    private void singlePlayer(ArrayList<Player> players) throws InterruptedException {
        boolean backHome = false;
        int tie = 0;
        Player ai = new Player();
        String aiName = "ai";
        ai.setName(aiName);
        players.add(ai);
        while (!backHome) {
            int randomIndex = random.nextInt(RockPaperScissors.values().length);
            RockPaperScissors randomChoice = RockPaperScissors.values()[randomIndex];
            RockPaperScissors userFighter = null;
            System.out.println("1- Rock \n2- Paper \n3- Scissors");
            try{
                userChoice = userInput.nextInt();
                if (userChoice == 1)
                    userFighter = RockPaperScissors.ROCK;
                else if (userChoice == 2)
                    userFighter = RockPaperScissors.PAPER;
                else if(userChoice == 3)
                    userFighter = RockPaperScissors.SCISSORS;
                else
                    System.out.println("Please enter one of the numbers provided (1,2,3).");

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
                case "player":
                    players.get(0).setScore(players.get(0).getScore() + 1);
                    break;
                case "ai":
                    players.get(1).setScore(players.get(1).getScore() + 1);
                    break;
                case "tie":
                    tie++;
                    break;
                default:
                    break;
            }
            System.out.println("Player " + players.get(0).getName() + " wins " + players.get(0).getScore() + "\n" +
                    "Player " + players.get(1).getName() + " wins " + players.get(1).getScore() + "\n" +
                    "Draws: " + tie + "\n");
            Thread.sleep(1000);
            System.out.println("do you want to play again or go back to main menu\n"+
                    "1- play again\n"+
                    "2- main menu");
            try{
                userChoice = userInput.nextInt();
                if (userChoice == 1){}
                else if (userChoice == 2) {
                    players.get(0).setScore(0);
                    players.remove(1);
                    backHome = true;
                }else
                    System.out.println("Please enter one of the numbers provided (1,2).");


            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n" +
                        "Please enter one of the numbers provided (1,2).");
                userInput.next();
            }
        }
    }
    private void Decider(ArrayList<Player> players) throws InterruptedException {
        boolean backHome = false;
        int tie = 0;
        System.out.println("Please enter player 2 name");
        String name = userInput.nextLine();
        Player player2 = new Player();
        player2.setName(name);
        players.add(player2);
        System.out.println("Hi " + player2.getName() + "\n");
        Thread.sleep(1000);
        while (!backHome) {
            int randomPlayer1 = random.nextInt(RockPaperScissors.values().length);
            RockPaperScissors player1Choice = RockPaperScissors.values()[randomPlayer1];
            int randomPlayer2 = random.nextInt(RockPaperScissors.values().length);
            RockPaperScissors player2Choice = RockPaperScissors.values()[randomPlayer2];

            System.out.println(players.get(0).getName() + " got: " + player1Choice);
            System.out.println(players.get(1).getName() + " got: " + player2Choice + "\n");
            String result = determineWinner(player1Choice, player2Choice);

            switch (result) {
                case "player":
                    players.get(0).setScore(players.get(0).getScore() + 1);
                    break;
                case "ai":
                    players.get(1).setScore(players.get(1).getScore() + 1);
                    break;
                case "tie":
                    tie++;
                    break;
                default:
                    break;
            }
            System.out.println("Player " + players.get(0).getName() + " wins " + players.get(0).getScore() + "\n" +
                    "Player " + players.get(1).getName() + " wins " + players.get(1).getScore() + "\n" +
                    "Draws: " + tie + "\n");
            Thread.sleep(1000);
            System.out.println("do you want to play again or go back to main menu\n"+
                    "1- play again\n"+
                    "2- main menu");
            try{
                userChoice = userInput.nextInt();
                if (userChoice == 1){}
                else if (userChoice == 2) {
                    players.get(0).setScore(0);
                    backHome = true;
                }else
                    System.out.println("Please enter one of the numbers provided (1,2).");


            }
            catch (InputMismatchException e){
                System.out.println("invalid option number \n" +
                        "Please enter one of the numbers provided (1,2).");
                userInput.next();
            }
        }
    }
    private static String determineWinner(RockPaperScissors playerChoice, RockPaperScissors opponentChoice) {
        if (playerChoice == opponentChoice) {
            return "tie";
        }

        switch (playerChoice) {
            case ROCK:
                return (opponentChoice == RockPaperScissors.SCISSORS) ? "player" : "ai";
            case PAPER:
                return (opponentChoice == RockPaperScissors.ROCK) ? "player" : "ai";
            case SCISSORS:
                return (opponentChoice == RockPaperScissors.PAPER) ? "player" : "ai";
            default:
                return "Invalid choice.";
        }
    }
}
