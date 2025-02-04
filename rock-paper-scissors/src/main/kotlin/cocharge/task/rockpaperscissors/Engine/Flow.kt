package cocharge.task.rockpaperscissors.Engine

import cocharge.task.rockpaperscissors.model.Modes
import cocharge.task.rockpaperscissors.model.Player
import cocharge.task.rockpaperscissors.service.GameModes
import java.util.*

class Flow {
    private val players = mutableListOf<Player>()

    fun startGame() {
        val gameModes = GameModes()
        val userInput = Scanner(System.`in`)

        println("Hello,\nWelcome to Rock Paper Scissors demo\nPlease enter your name")
        val name = userInput.nextLine()

        val player1 = Player(name = name)
        players.add(player1)

        println("Hi ${player1.name}\n")
        Thread.sleep(1000)
        homeOptionsPrint()

        while (true) {
            try {
                val userChoice = userInput.nextInt()
                if (validateChoice(userChoice)) {
                    val mode = Modes.fromInt(userChoice)
                    if (mode == null) {
                        println("Thank you for playing\nHope you enjoyed!!!.")
                        break
                    }
                    gameModes.gameMode(players, mode)
                    homeOptionsPrint()
                } else {
                    println("Please enter one of the numbers provided (1, 2, 3, 4).")
                }
            } catch (e: InputMismatchException) {
                println("Invalid option number\nPlease enter one of the numbers provided (1, 2, 3, 4).")
                userInput.next()  // Clear the invalid input
            }
        }
    }

    private fun homeOptionsPrint() {
        println(
                "Please choose the preferred mode\n" +
                        "1- Minimal Requirement\n" +
                        "2- Single Player (against computer)\n" +
                        "3- Decider (two players and the game randomly picks for each one and decides the winner) \n" +
                        "4- Quit the game"
        )
    }

    private fun validateChoice(userChoice: Int): Boolean {
        return userChoice in 1..4
    }
}
