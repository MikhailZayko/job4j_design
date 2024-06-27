package ru.job4j.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.storage.model.Food;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void whenAddedThenSize1() {
        Store trash = new Trash();
        Food food = new Food("Сыр", LocalDate.of(2024, Month.JUNE, 26),
                LocalDate.of(2024, Month.JUNE, 1), 135.50);
        trash.add(food);
        assertThat(trash.findAll()).hasSize(1);
    }

    @Test
    void whenWasNotAddedThenSize0() {
        Store trash = new Trash();
        Food food = new Food("Хлеб", LocalDate.of(2024, Month.JULY, 23),
                LocalDate.of(2024, Month.JUNE, 1), 32.50);
        trash.add(food);
        assertThat(trash.findAll()).hasSize(0);
    }
}