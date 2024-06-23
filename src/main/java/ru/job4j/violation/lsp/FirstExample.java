package ru.job4j.violation.lsp;

/**
 * Подкласс Penguin не может летать, поэтому метод fly() выбрасывает исключение.
 * Это нарушает ожидание, что все птицы могут летать, и нарушает принцип подстановки,
 * так как объект Penguin не может заменить объект Bird в общем случае.
 */

public class FirstExample {
    public static void main(String[] args) {
        Bird bird = new Penguin();
        bird.fly();
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin can't fly");
    }
}


