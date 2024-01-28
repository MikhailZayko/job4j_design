package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlAttribute
    private String city;

    @XmlAttribute
    private String street;

    public Address() {

    }

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
