package ru.job4j.io;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new FileReader("data/input.txt"))) {
            input.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}