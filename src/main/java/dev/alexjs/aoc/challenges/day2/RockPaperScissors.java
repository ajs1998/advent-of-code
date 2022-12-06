package dev.alexjs.aoc.challenges.day2;

public enum RockPaperScissors {

    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    public final String theirs;
    public final String mine;

    private final int value;

    RockPaperScissors(String theirs, String mine, int value) {
        this.theirs = theirs;
        this.mine = mine;
        this.value = value;
    }

    public static RockPaperScissors of(char symbol) {
        return switch (symbol) {
            case 'A', 'X' -> ROCK;
            case 'B', 'Y' -> PAPER;
            case 'C', 'Z' -> SCISSORS;
            default -> throw new IllegalArgumentException("Invalid symbol: " + symbol);
        };
    }

    public static RockPaperScissors of(int score) {
        return switch (score) {
            case 1 -> ROCK;
            case 2 -> PAPER;
            case 3 -> SCISSORS;
            default -> throw new IllegalArgumentException("Invalid score: " + score);
        };
    }

    public RockPaperScissors ofResult(char result) {
        return switch (result) {
            case 'X' -> of((value + 1) % 3 + 1);
            case 'Y' -> of(value);
            case 'Z' -> of(value % 3 + 1);
            default -> throw new IllegalArgumentException("Invalid result: " + result);
        };
    }

    public int scoreAgainst(RockPaperScissors theirs) {
        RockPaperScissors theyLose = of(value ^ ((value) % 3 + 1));
        if (theirs.equals(theyLose)) {
            return value + 6;
        }
        RockPaperScissors theyWin = of(value ^ ((value + 1) % 3 + 1));
        if (theirs.equals(theyWin)) {
            return value;
        } else {
            return value + 3;
        }
    }

}
