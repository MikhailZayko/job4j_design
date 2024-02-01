package ru.job4j.io.search;

import ru.job4j.io.ArgsName;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileSearch {

    public static void fileSearchAndCopy(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Path dir = Path.of(argsName.get("d"));
        Path out = Path.of(argsName.get("o"));
        Predicate<Path> predicate = findPredicate(args);
        try (Stream<Path> pathStream = Files.walk(dir)) {
            Optional<Path> find = pathStream
                    .filter(predicate)
                    .findFirst();
            Path file;
            if (find.isPresent()) {
                file = find.get();
            } else {
                throw new IllegalArgumentException("File not found");
            }
            Files.copy(file, out);
        }
    }

    private static Predicate<Path> findPredicate(String[] args) {
        Predicate<Path> result;
        ArgsName argsName = ArgsName.of(args);
        String type = argsName.get("t");
        String name = argsName.get("n");
        switch (type) {
            case "name" -> {
                result = path -> path.getFileName().toString().equals(name);
            }
            case "mask" -> {
                PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + name);
                result = path -> pathMatcher.matches(path.getFileName());
            }
            case "regex" -> {
                Pattern pattern = Pattern.compile(name);
                result = path -> pattern.matcher(path.getFileName().toString()).matches();
            }
            default -> throw new IllegalArgumentException("Invalid 'type' argument");
        }
        return result;
    }

    private static void validateKeys(String[] args) {
        if (!args[0].startsWith("-d=")) {
            throw new IllegalArgumentException("The first key should be 'd'");
        }
        if (!args[1].startsWith("-n=")) {
            throw new IllegalArgumentException("The second key should be 'n'");
        }
        if (!args[2].startsWith("-t=")) {
            throw new IllegalArgumentException("The third key should be 't'");
        }
        if (!args[3].startsWith("-o=")) {
            throw new IllegalArgumentException("The fourth key should be 'o'");
        }
    }

    public static void main(String[] args) throws IOException {
        validateKeys(args);
        fileSearchAndCopy(args);
    }
}
