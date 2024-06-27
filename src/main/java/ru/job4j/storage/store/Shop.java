package ru.job4j.storage.store;

import ru.job4j.storage.model.Food;
import ru.job4j.storage.util.ExpirationCalculator;

public class Shop extends AbstractStore {

    @Override
    public void add(Food food) {
        double expiration = ExpirationCalculator.calculate(food);
        if (expiration >= 25 && expiration <= 75) {
            foodList.add(food);
        } else if (expiration > 75 && expiration < 100) {
            food.setDiscount(20);
            food.setPrice(food.getPrice() * 0.8);
            foodList.add(food);
        }
    }
}
