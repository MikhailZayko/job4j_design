package ru.job4j.generics;

import java.util.Objects;

public class Tiger extends Predator {

    private String genus;

    public Tiger(String kingdom, String squad, String genus) {
        super(kingdom, squad);
        this.genus = genus;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
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
        Tiger tiger = (Tiger) o;
        return Objects.equals(genus, tiger.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), genus);
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "genus='" + genus + '\''
                + '}';
    }
}
