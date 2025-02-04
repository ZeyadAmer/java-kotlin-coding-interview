package cocharge.task.rockpaperscissors.model

enum class Modes {
    Decider,
    MinimalRequirement,
    SinglePlayer;

    companion object {
        fun fromInt(userInput: Int): Modes? {
        return when (userInput) {
            1 -> MinimalRequirement
            2 -> SinglePlayer
            3 -> Decider
                else -> null
        }
        }
    }
}
