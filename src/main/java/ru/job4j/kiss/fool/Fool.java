package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    private static final String GAME = "Игра FizzBuzz.";

    private static final String ERROR = "Ошибка. Начинай снова.";

    public static String correctAnswer(int number) {
        var result = String.valueOf(number);
        if (number % 3 == 0 && number % 5 == 0) {
            result = "FizzBuzz";
        } else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0) {
            result = "Buzz";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(GAME);
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(correctAnswer(startAt));
            startAt++;
            if (!correctAnswer(startAt).equals(input.nextLine())) {
                System.out.println(ERROR);
                startAt = 0;
            }
            startAt++;
        }
    }
}