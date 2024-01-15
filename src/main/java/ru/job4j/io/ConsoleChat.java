package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> log = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        log.add(input);
        OUTER:
        while (!OUT.equals(input)) {
            if (STOP.equals(input)) {
                while (!CONTINUE.equals(input)) {
                    input = scanner.nextLine();
                    log.add(input);
                    if (OUT.equals(input)) {
                        break OUTER;
                    }
                }
            }
            String answer = botAnswers.get(random.nextInt(botAnswers.size()));
            log.add(answer);
            System.out.println(answer);
            input = scanner.nextLine();
            log.add(input);
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            answers = reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/bot_log.txt", "data/bot_answers.txt");
        consoleChat.run();
    }
}
