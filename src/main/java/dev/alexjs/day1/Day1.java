package dev.alexjs.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Day1 {

    public Day1() {

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
            System.out.println("Max calories: " + elves.get(size - 1));
            System.out.println();

            // Puzzle 2 Answer
            int top3 = elves.get(size - 1) + elves.get(size - 2) + elves.get(size - 3);
            System.out.println("Top 3: " + top3);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    public static void main(String[] args) throws Throwable {

        new Day1();

    }

}
