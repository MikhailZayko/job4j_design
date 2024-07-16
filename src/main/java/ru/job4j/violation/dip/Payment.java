package ru.job4j.violation.dip;

/**
 * PaymentService зависит от конкретного класса FileLogger,
 * что затрудняет замену логирования на другую реализацию.
 */

public class Payment {

    private int id;

    public int getId() {
        return id;
    }
}

class PaymentService {

    private FileLogger logger;

    public PaymentService() {
        this.logger = new FileLogger();
    }

    public void processPayment(Payment payment) {
        logger.log("Payment processed: " + payment.getId());
    }
}

class FileLogger {
    public void log(String message) {

    }
}