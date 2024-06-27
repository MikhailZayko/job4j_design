package ru.job4j.storage.store;

import ru.job4j.storage.model.Food;
import ru.job4j.storage.util.ExpirationCalculator;

public class Warehouse extends AbstractStore {

    @Override
    public void add(Food food) {
        if (ExpirationCalculator.calculate(food) < 25) {
            foodList.add(food);
        }
    }
}
