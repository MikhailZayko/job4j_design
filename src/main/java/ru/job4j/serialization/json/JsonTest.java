package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonTest {

    public static void main(String[] args) {
        Man man = new Man("Ivan", 35, true,
                new String[]{"Anna", "Petr"}, new Address("Moscow", "Pushkin"));
        Gson gson = new GsonBuilder().create();
        String manJson = gson.toJson(man);
        System.out.println(manJson);
        Man manFromJson = gson.fromJson(manJson, Man.class);
        System.out.println(manFromJson);
    }
}
