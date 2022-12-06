package dev.alexjs.aoc;

import java.io.*;
import java.util.List;
import java.util.Objects;

public interface Challenge {

    List<Object> run();

    int getDay();

    default List<String> readInput() {
        try (InputStream stream = Objects.requireNonNull(this.getClass().getResourceAsStream("/day" + getDay() + "/input.txt"));
             InputStreamReader streamReader = new InputStreamReader(stream);
             BufferedReader reader = new BufferedReader(streamReader)) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
