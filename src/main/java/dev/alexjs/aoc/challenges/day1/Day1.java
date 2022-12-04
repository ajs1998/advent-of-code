package dev.alexjs.aoc.challenges.day1;

import com.google.auto.service.AutoService;
import dev.alexjs.aoc.Challenge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AutoService(Challenge.class)
public class Day1 implements Challenge {

    private static final Logger log = LogManager.getLogger(Day1.class);

    public List<Object> run() {

        try (InputStream stream = this.getClass().getResourceAsStream("/day1/input.txt");
             InputStreamReader streamReader = new InputStreamReader(stream);
             BufferedReader reader = new BufferedReader(streamReader)) {

            // Read all lines
            List<String> lines = reader.lines().toList();

            // Sum the calories carried by each elf
            List<Integer> elves = new ArrayList<>();
            int sum = 0;
            for (String line : lines) {
                if (line.isBlank()) {
                    elves.add(sum);
                    sum = 0;
                    continue;
                }
                sum += Integer.parseInt(line);
            }
            int size = elves.size();

            // Sort by calories
            elves.sort(Comparator.naturalOrder());

            // Puzzle 1 Answer
            int max = elves.get(size - 1);
            log.info("Max calories: " + max);

            // Puzzle 2 Answer
            int top3 = elves.get(size - 1) + elves.get(size - 2) + elves.get(size - 3);
            log.info("Top 3: " + top3);

            return List.of(max, top3);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public int getDay() {
        return 1;
    }

}
