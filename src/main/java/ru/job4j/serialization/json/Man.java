package ru.job4j.serialization.json;

import java.util.Arrays;

public class Man {

    private final String name;

    private final int age;

    private final boolean married;

    private final String[] children;

    private final Address address;

    public Man(String name, int age, boolean married, String[] children, Address address) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.children = children;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Man{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", married=" + married
                + ", children=" + Arrays.toString(children)
                + ", address=" + address
                + '}';
    }
}
