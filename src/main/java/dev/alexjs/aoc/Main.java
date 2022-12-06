package dev.alexjs.aoc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Throwable {

        // Load all the challenges
        ServiceLoader<Challenge> loader = ServiceLoader.load(Challenge.class);
        List<Challenge> challenges = new ArrayList<>();
        for (Challenge challenge : loader) {
            challenges.add(challenge);
        }
        challenges.sort(Comparator.comparingInt(Challenge::getDay));

        for (Challenge challenge : challenges) {
            log.info("-- Day " + challenge.getDay() + "--");
            List<Object> results = challenge.run();
        }

    }

}
