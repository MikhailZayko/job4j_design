package ru.job4j.storage.store;

import ru.job4j.storage.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> findAll() {
        return List.copyOf(foodList);
    }

    @Override
    public void deleteAll() {
        foodList.clear();
    }
}
