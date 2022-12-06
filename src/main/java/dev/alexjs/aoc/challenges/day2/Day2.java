package dev.alexjs.aoc.challenges.day2;

import com.google.auto.service.AutoService;
import dev.alexjs.aoc.Challenge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@AutoService(Challenge.class)
public class Day2 implements Challenge {

    private static final Logger log = LogManager.getLogger(Day2.class);

    @Override
    public List<Object> run() {

        List<String> lines = readInput();

        int firstScore = 0;
        for (String game : lines) {
            RockPaperScissors theirs = RockPaperScissors.of(game.charAt(0));
            RockPaperScissors mine = RockPaperScissors.of(game.charAt(2));
            int gameScore = mine.scoreAgainst(theirs);
            firstScore += gameScore;
        }
        log.info("First score: {}", firstScore);

        int secondScore = 0;
        for (String game : lines) {
            RockPaperScissors theirs = RockPaperScissors.of(game.charAt(0));
            RockPaperScissors mine = theirs.ofResult(game.charAt(2));

            int gameScore = mine.scoreAgainst(theirs);
            secondScore += gameScore;
        }
        log.info("Second score: {}", secondScore);

        return List.of(firstScore, secondScore);

    }

    @Override
    public int getDay() {
        return 2;
    }

}
