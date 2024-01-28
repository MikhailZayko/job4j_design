package ru.job4j.serialization.json;

public class Address {

    private final String city;

    private final String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + '}';
    }
}
