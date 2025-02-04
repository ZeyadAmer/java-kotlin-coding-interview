package cocharge.task.rockpaperscissors

import cocharge.task.rockpaperscissors.Engine.Flow
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


class RockPaperScissorsApplication

fun main(args: Array<String>) {
        runApplication<RockPaperScissorsApplication>(*args)
val gameFlow = Flow()
    gameFlow.startGame()
}