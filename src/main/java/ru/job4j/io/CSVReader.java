package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        List<String> filter = Arrays.stream(argsName.get("filter").split(",")).toList();
        List<StringJoiner> resultLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(argsName.get("path")));
             PrintStream printStream = "stdout".equals(out) ? null : new PrintStream(new FileOutputStream(out))) {
            List<String> headers = Arrays.stream(scanner.nextLine().split(delimiter)).toList();
            List<Integer> indexes = filter.stream()
                    .map(headers::indexOf)
                    .toList();
            StringJoiner firstLine = new StringJoiner(delimiter);
            filter.forEach(firstLine::add);
            resultLines.add(firstLine);
            while (scanner.hasNextLine()) {
                List<String> words = Arrays.stream(scanner.nextLine().split(delimiter)).toList();
                StringJoiner resultLine = new StringJoiner(delimiter);
                indexes.forEach(i -> resultLine.add(words.get(i)));
                resultLines.add(resultLine);
            }
            if (printStream == null) {
                resultLines.forEach(System.out::println);
            } else {
                resultLines.forEach(printStream::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateArgs(ArgsName argsName) {
        Path path = Path.of(argsName.get("path"));
        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException(
                    String.format("'%s' is not a file", path));
        }
        if (!path.toString().endsWith(".csv")) {
            throw new IllegalArgumentException("The file should be in CSV format");
        }
        String delimiter = argsName.get("delimiter");
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("Delimiter is empty");
        }
        String filter = argsName.get("filter");
        if (filter.isEmpty()) {
            throw new IllegalArgumentException("Filter is empty");
        }
        Path out = Path.of(argsName.get("out"));
        if (!"stdout".equals(out.toString()) && !out.toString().endsWith(".csv")) {
            throw new IllegalArgumentException("OUT should be should be in CSV format or 'stdout'");
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        validateArgs(argsName);
        handle(argsName);
    }
}
