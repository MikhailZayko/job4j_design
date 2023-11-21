package ru.job4j.generics;

import java.util.Objects;

public class Animal {

    private String kingdom;

    public Animal(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(kingdom, animal.kingdom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kingdom);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + kingdom + '\''
                + '}';
    }
}
