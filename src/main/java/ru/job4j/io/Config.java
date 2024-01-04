package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            for (String s : reader.lines().toList()) {
                if (s.startsWith("#") || s.isBlank()) {
                    continue;
                }
                if (!s.contains("=")) {
                    throw new IllegalArgumentException("key=value pattern violation");
                }
                String[] entry = s.split("=", 2);
                if (entry[0].isBlank() || entry[1].isBlank()) {
                    throw new IllegalArgumentException("key=value pattern violation");
                }
                values.put(entry[0], entry[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/pair_with_comment.properties"));
    }
}