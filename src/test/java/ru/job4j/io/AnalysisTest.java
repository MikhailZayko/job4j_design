package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.*;

class AnalysisTest {

    @Test
    void unavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.log").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("400 12:56:01");
            output.println("500 12:57:01");
            output.println("400 12:58:01");
            output.println("300 13:59:01");
            output.println("500 14:01:02");
            output.print("200 15:02:02");
        }
        File target = tempDir.resolve("target.csv").toFile();
        new Analysis().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        String line = System.lineSeparator();
        StringBuilder expected = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(s -> expected.append(s).append(line));
        }
        String result = "12:56:01;13:59:01;" + line
                + "14:01:02;15:02:02;" + line;
        assertThat(result).hasToString(expected.toString());
    }
}