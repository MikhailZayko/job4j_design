package ru.job4j.violation.dip;

/**
 * PaymentProcessor жестко закодирован для использования CreditCardPayment,
 * что делает его трудно расширяемым для других типов платежей.
 */

public class PaymentProcessor {

    public void processPayment(String paymentType) {
        if (paymentType.equals("creditcard")) {
            CreditCardPayment payment = new CreditCardPayment();
            payment.pay();
        }
    }
}

class CreditCardPayment {
    public void pay() {
    }
}