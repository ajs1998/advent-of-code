package dev.alexjs.aoc;

import dev.alexjs.aoc.challenges.day2.RockPaperScissors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay2 {

    @Test
    public void test() {

        Assertions.assertEquals(1 + 3, RockPaperScissors.ROCK.scoreAgainst(RockPaperScissors.ROCK));
        Assertions.assertEquals(1 + 0, RockPaperScissors.ROCK.scoreAgainst(RockPaperScissors.PAPER));
        Assertions.assertEquals(1 + 6, RockPaperScissors.ROCK.scoreAgainst(RockPaperScissors.SCISSORS));
        Assertions.assertEquals(2 + 6, RockPaperScissors.PAPER.scoreAgainst(RockPaperScissors.ROCK));
        Assertions.assertEquals(2 + 3, RockPaperScissors.PAPER.scoreAgainst(RockPaperScissors.PAPER));
        Assertions.assertEquals(2 + 0, RockPaperScissors.PAPER.scoreAgainst(RockPaperScissors.SCISSORS));
        Assertions.assertEquals(3 + 0, RockPaperScissors.SCISSORS.scoreAgainst(RockPaperScissors.ROCK));
        Assertions.assertEquals(3 + 6, RockPaperScissors.SCISSORS.scoreAgainst(RockPaperScissors.PAPER));
        Assertions.assertEquals(3 + 3, RockPaperScissors.SCISSORS.scoreAgainst(RockPaperScissors.SCISSORS));

        Assertions.assertEquals(RockPaperScissors.ROCK, RockPaperScissors.PAPER.ofResult('X'));
        Assertions.assertEquals(RockPaperScissors.ROCK, RockPaperScissors.ROCK.ofResult('Y'));
        Assertions.assertEquals(RockPaperScissors.ROCK, RockPaperScissors.SCISSORS.ofResult('Z'));
        Assertions.assertEquals(RockPaperScissors.PAPER, RockPaperScissors.SCISSORS.ofResult('X'));
        Assertions.assertEquals(RockPaperScissors.PAPER, RockPaperScissors.PAPER.ofResult('Y'));
        Assertions.assertEquals(RockPaperScissors.PAPER, RockPaperScissors.ROCK.ofResult('Z'));
        Assertions.assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.ROCK.ofResult('X'));
        Assertions.assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.SCISSORS.ofResult('Y'));
        Assertions.assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.PAPER.ofResult('Z'));

    }

}
