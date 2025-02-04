package cocharge.task.rockpaperscissors.model;

public enum RockPaperScissors {
    ROCK,
    PAPER,
    SCISSORS;

    public static RockPaperScissors fromInt(int userChoice){
        switch (userChoice){
            case 1: return ROCK;
            case 2: return PAPER;
            case 3: return SCISSORS;
            default: return null;
        }
    }
}
