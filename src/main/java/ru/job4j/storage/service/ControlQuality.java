package ru.job4j.storage.service;

import ru.job4j.storage.model.Food;
import ru.job4j.storage.store.Store;

import java.util.List;

public class ControlQuality {

    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void distribution(Food food) {
        storeList.forEach(store -> store.add(food));
    }

    public void resort() {
        List<Food> foodList = storeList.stream()
                .flatMap(store -> store.findAll().stream())
                .toList();
        storeList.forEach(Store::deleteAll);
        foodList.forEach(this::distribution);
    }
}
