package dev.alexjs.aoc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Throwable {

        hi();

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

    public static void hi() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://adventofcode.com/2022/day/2"))
                .build(), HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        // TODO extract <article></article>
        // TODO GET /input

    }

}
