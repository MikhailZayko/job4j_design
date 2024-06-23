package ru.job4j.violation.lsp;

/**
 * Подкласс FreePayment изменяет поведение метода processPayment, игнорируя негативные суммы.
 * Это нарушает принцип LSP, так как объекты подклассов FreePayment не могут быть подставлены
 * вместо объектов суперкласса Payment без нарушения логики проверки.
 */

public class ThirdExample {
    public static void main(String[] args) {
        Payment payment = new FreePayment();
        payment.processPayment(-10);
    }
}

class Payment {
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}

class FreePayment extends Payment {
    @Override
    public void processPayment(double amount) {

    }
}



