package ru.job4j.violation.ocp;

/**
 * Если нужно добавить новый тип скидки,то придется изменить метод calculateDiscount, добавив новый case.
 * Это нарушает принцип OCP, так как требует изменения существующего кода для добавления новой функциональности.
 */

public class DiscountCalculator {

    public double calculateDiscount(String discountType, double price) {
        return switch (discountType) {
            case "Seasonal" -> price * 0.9;
            case "Black Friday" -> price * 0.7;
            default -> price;
        };
    }
}
