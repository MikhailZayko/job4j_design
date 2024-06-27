package ru.job4j.violation.isp;

/**
 * Car вынужден реализовать метод fly, который ему не нужен.
 */

interface Vehicle {

    void drive();

    void fly();
}

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Car driving");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Car cannot fly");
    }
}