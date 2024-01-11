package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getAbsolutePath()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateArgs(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName argsName = ArgsName.of(args);
        Path directory = Path.of(argsName.get("d"));
        String exclude = argsName.get("e");
        String output = argsName.get("o");
        if (!Files.exists(directory)) {
            throw new IllegalArgumentException("Directory does not exist");
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Enter extension format");
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException("The archive name must have a .zip extension");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        validateArgs(args);
        ArgsName argsName = ArgsName.of(args);
        Path directory = Path.of(argsName.get("d"));
        Predicate<Path> condition = p -> !p.endsWith(argsName.get("e"));
        File target = new File(argsName.get("o"));
        zip.packFiles(Search.search(directory, condition), target);
    }
}
