package cocharge.task.rockpaperscissors.model

enum class RockPaperScissors {
    ROCK,
    PAPER,
    SCISSORS;

    companion object {
        fun fromInt(userChoice: Int): RockPaperScissors? {
        return when (userChoice) {
            1 -> ROCK
            2 -> PAPER
            3 -> SCISSORS
                else -> null
        }
        }
    }
}
