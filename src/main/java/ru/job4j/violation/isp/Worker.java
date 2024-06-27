package ru.job4j.violation.isp;

/**
 * Robot вынужден реализовать метод eat, который ему не нужен.
 */

interface Worker {

    void work();

    void eat();
}

class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Robot working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robot cannot eat");
    }
}