package ru.job4j.violation.srp;

/**
 * Этот класс выполняет две задачи: управление данными пользователя и отображение информации о пользователе.
 * Эти задачи лучше разделить на два класса: один для управления данными, другой для отображения.
 */

public class User {

    private String name;

    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printUser() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
