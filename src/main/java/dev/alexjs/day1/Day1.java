package dev.alexjs.day1;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Day1 {

    public Day1() {

        try (InputStream stream = this.getClass().getResourceAsStream("/day1/input.txt");
             InputStreamReader streamReader = new InputStreamReader(stream);
             BufferedReader reader = new BufferedReader(streamReader)) {

            LinkedList<String> lines = new LinkedList<>(reader.lines().toList());

            LinkedList<Integer> elves = new LinkedList<>();
            int sum = 0;
            for (String line : lines) {
                if (line.isBlank()) {
                    elves.add(sum);
                    sum = 0;
                    continue;
                }
                sum += Integer.parseInt(line);
            }
            elves.sort(Comparator.naturalOrder());

            System.out.println("Max calories: " + elves.peekLast());
            System.out.println();

            int top3 = elves.get(elves.size() - 1) + elves.get(elves.size() - 2) + elves.get(elves.size() - 3);
            System.out.println("Top 3: " + top3);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    public static void main(String[] args) throws Throwable {

        new Day1();

    }

}
