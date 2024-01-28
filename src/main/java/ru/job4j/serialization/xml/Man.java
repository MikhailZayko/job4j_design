package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "man")
@XmlAccessorType(XmlAccessType.FIELD)
public class Man {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private boolean married;

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "child")
    private String[] children;

    private Address address;

    public Man() {

    }

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
