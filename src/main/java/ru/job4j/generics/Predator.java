package ru.job4j.generics;

import java.util.Objects;

public class Predator extends Animal {

    private String squad;

    public Predator(String kingdom, String squad) {
        super(kingdom);
        this.squad = squad;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Predator predator = (Predator) o;
        return Objects.equals(squad, predator.squad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), squad);
    }

    @Override
    public String toString() {
        return "Predator{"
                + "squad='" + squad + '\''
                + '}';
    }
}
