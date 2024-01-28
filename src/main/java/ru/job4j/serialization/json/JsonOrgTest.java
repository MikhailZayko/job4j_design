package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Arrays;

public class JsonOrgTest {

    public static void main(String[] args) {
        JSONObject jsonAddress = new JSONObject()
                .put("city", "Moscow")
                .put("street", "Pushkin");
        JSONArray jsonChildren = new JSONArray(Arrays.asList("Anna", "Petr"));
        Man man = new Man("Ivan", 35, true,
                new String[]{"Viktor", "Alexandr"}, new Address("Rostov", "Red"));
        JSONObject jsonObject = new JSONObject()
                .put("name", man.getName())
                .put("age", man.getAge())
                .put("married", man.isMarried())
                .put("children", jsonChildren)
                .put("address", jsonAddress);
        System.out.println(jsonObject);
        String jsonString = new JSONObject(man).toString();
        System.out.println(jsonString);
    }
}
