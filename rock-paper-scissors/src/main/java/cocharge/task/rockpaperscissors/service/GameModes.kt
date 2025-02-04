package cocharge.task.rockpaperscissors.service

import cocharge.task.rockpaperscissors.model.Modes
import cocharge.task.rockpaperscissors.model.Player
import cocharge.task.rockpaperscissors.model.RockPaperScissors
import java.util.Random
import java.util.Scanner

class GameModes {
    private var rounds = 0
    private var userChoice = 0
    private var tie = 0
    private val userInput = Scanner(System.`in`)

    fun gameMode(players: MutableList<Player>, mode: Modes) {
        rounds = 0
        when (mode) {
            Modes.MinimalRequirement -> minimalRequirements(players)
            Modes.SinglePlayer -> singlePlayer(players)
            Modes.Decider -> decider(players)
        }
    }

    private fun minimalRequirements(players: MutableList<Player>) {
        tie = 0
        val ai = Player("AI", 0)
        players.add(ai)
        var backHome = false

        while (!backHome) {
            repeat(100) {
                when (randomChoice()) {
                    RockPaperScissors.PAPER -> players[1].score++
                    RockPaperScissors.SCISSORS -> players[0].score++
                    RockPaperScissors.ROCK -> tie++
                }
            }
            backHome = score(players)
            players[0].score = 0
            players[1].score = 0
            tie = 0
        }
        players.removeAt(1)
    }

    private fun singlePlayer(players: MutableList<Player>) {
        var backHome = false
        tie = 0
        val ai = Player("AI", 0)
        players.add(ai)

        while (!backHome) {
            val randomChoice = randomChoice()
            var userFighter: RockPaperScissors?

            println("1- Rock \n2- Paper \n3- Scissors")
            try {
                userChoice = userInput.nextInt()
                while (true) {
                    userFighter = RockPaperScissors.fromInt(userChoice)
                    if (userFighter != null) break
                    println("Please enter one of the numbers provided (1,2,3).")
                    userChoice = userInput.nextInt()
                }
            } catch (e: Exception) {
                println("Invalid option number \nPlease enter one of the numbers provided (1,2,3).")
                userInput.next()
                continue
            }

            println("You chose: $userFighter")
            println("The opponent chose: $randomChoice\n")

            when (determineWinner(userFighter!!, randomChoice)) {
                "player1" -> players[0].score++
                "player2" -> players[1].score++
                "tie" -> tie++
            }

            backHome = score(players)
        }
        players.removeAt(1)
    }

    private fun decider(players: MutableList<Player>) {
        var backHome = false
        tie = 0
        println("Please enter player 2 name")
        val name = userInput.next()
        val player2 = Player(name, 0)
        players.add(player2)

        println("Hi ${player2.name}\n")
        Thread.sleep(1000)

        while (!backHome) {
            val player1Choice = randomChoice()
            val player2Choice = randomChoice()

            println("${players[0].name} got: $player1Choice")
            println("${players[1].name} got: $player2Choice\n")

            when (determineWinner(player1Choice, player2Choice)) {
                "player1" -> players[0].score++
                "player2" -> players[1].score++
                "tie" -> tie++
            }

            backHome = score(players)
        }
        players.removeAt(1)
    }

    private fun randomChoice(): RockPaperScissors {
        return RockPaperScissors.values().random()
    }

    private fun score(players: MutableList<Player>): Boolean {
        println(
            "Player ${players[0].name} wins: ${players[0].score}\n" +
                    "Player ${players[1].name} wins: ${players[1].score}\n" +
                    "Draws: $tie\n"
        )
        Thread.sleep(1000)

        println("Do you want to play again or go back to main menu?\n1- Play again\n2- Main menu")
        while (true) {
            try {
                userChoice = userInput.nextInt()
                return when (userChoice) {
                    1 -> false
                    2 -> {
                        players[0].score = 0
                        true
                    }
                    else -> {
                        println("Please enter one of the numbers provided (1,2).")
                        false
                    }
                }
            } catch (e: Exception) {
                println("Invalid option number \nPlease enter one of the numbers provided (1,2).")
                userInput.next()
            }
        }
    }

    companion object {
        fun determineWinner(playerChoice: RockPaperScissors, opponentChoice: RockPaperScissors): String {
            return when {
                playerChoice == opponentChoice -> "tie"
                (playerChoice == RockPaperScissors.ROCK && opponentChoice == RockPaperScissors.SCISSORS) ||
                        (playerChoice == RockPaperScissors.PAPER && opponentChoice == RockPaperScissors.ROCK) ||
                        (playerChoice == RockPaperScissors.SCISSORS && opponentChoice == RockPaperScissors.PAPER) -> "player1"
                else -> "player2"
            }
        }
    }
}
