package ru.job4j.storage.store;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.storage.model.Food;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

@Disabled
class WarehouseTest {

    @Test
    void whenAddedThenSize1() {
        Store warehouse = new Warehouse();
        Food food = new Food("Сыр", LocalDate.of(2024, Month.JULY, 25),
                LocalDate.of(2024, Month.JUNE, 25), 135.50);
        warehouse.add(food);
        assertThat(warehouse.findAll()).hasSize(1);
    }

    @Test
    void whenWasNotAddedThenSize0() {
        Store warehouse = new Warehouse();
        Food food = new Food("Хлеб", LocalDate.of(2024, Month.JULY, 23),
                LocalDate.of(2024, Month.JUNE, 1), 32.50);
        warehouse.add(food);
        assertThat(warehouse.findAll()).hasSize(0);
    }
}