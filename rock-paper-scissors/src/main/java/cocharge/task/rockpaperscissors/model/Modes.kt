package cocharge.task.rockpaperscissors.model;

public enum Modes {
    Decider,
    MinimalRequirement,
    SingePlayer;


    public static Modes fromInt(int userInput) {
        switch (userInput) {
            case 1:
                return Modes.MinimalRequirement;
            case 2:
                return Modes.SingePlayer;
            case 3:
                return Modes.Decider;
            default:
                return null;
        }
    }
    }
