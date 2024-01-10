package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validateArgs(args);
        Path start = Paths.get(args[0]);
        search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validateArgs(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Enter starting directory and file extension");
        }
        Path directory = Paths.get(args[0]);
        String extension = args[1];
        if (!Files.exists(directory)) {
            throw new IllegalArgumentException("Directory does not exist");
        }
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException("This is not a directory");
        }
        if (!extension.startsWith(".") || extension.length() < 2) {
            throw new IllegalArgumentException("Enter the correct file extension");
        }
    }
}
