package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty key = new FileProperty(file.toFile().length(), file.getFileName().toString());
        files.computeIfAbsent(key, k -> new ArrayList<>()).add(file);
        return super.visitFile(file, attributes);
    }

    public void getDuplicates() {
        for (var entry : files.entrySet()) {
            FileProperty key = entry.getKey();
            List<Path> values = entry.getValue();
            if (values.size() > 1) {
                System.out.println(key.getName() + " - " + key.getSize() / 1024.0 + "KB");
                for (Path p : values) {
                    System.out.println(p.toAbsolutePath());
                }
            }
        }
    }
}
