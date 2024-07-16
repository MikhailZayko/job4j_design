package ru.job4j.storage.store;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.storage.model.Food;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ShopTest {

    @Test
    void whenAddedThenSize1AndNoDiscount() {
        Store shop = new Shop();
        Food food = new Food("Сыр", LocalDate.of(2024, Month.JULY, 18),
                LocalDate.of(2024, Month.JUNE, 18), 135.50);
        shop.add(food);
        assertThat(shop.findAll()).hasSize(1);
        assertThat(food.getPrice()).isEqualTo(135.50);
    }

    @Test
    void whenAddedThenSize1AndDiscount() {
        Store shop = new Shop();
        Food food = new Food("Сыр", LocalDate.of(2024, Month.JULY, 3),
                LocalDate.of(2024, Month.JUNE, 3), 150.0);
        shop.add(food);
        assertThat(shop.findAll()).hasSize(1);
        assertThat(food.getPrice()).isEqualTo(120);
    }

    @Test
    void whenWasNotAddedThenSize0() {
        Store shop = new Shop();
        Food food = new Food("Хлеб", LocalDate.of(2024, Month.JUNE, 25),
                LocalDate.of(2024, Month.JUNE, 18), 32.50);
        shop.add(food);
        assertThat(shop.findAll()).hasSize(0);
    }
}