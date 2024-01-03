package ru.job4j.io;

import java.io.FileOutputStream;

public class MultiplyFile {

    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/multiply.txt")) {
            for (int i = 2; i < 10; i++) {
                output.write(String.format("1 * %d = %d", i, i).getBytes());
                output.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
