package ru.job4j.storage.util;

import ru.job4j.storage.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ExpirationCalculator {

    public static double calculate(Food food) {
        return (double) ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now())
                / ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate()) * 100;
    }
}
