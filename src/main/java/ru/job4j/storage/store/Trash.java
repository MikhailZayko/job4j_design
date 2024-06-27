package ru.job4j.storage.store;

import ru.job4j.storage.model.Food;
import ru.job4j.storage.util.ExpirationCalculator;

public class Trash extends AbstractStore {

    @Override
    public void add(Food food) {
        if (ExpirationCalculator.calculate(food) >= 100) {
            foodList.add(food);
        }
    }
}
