package ru.job4j.storage.service;

import org.junit.jupiter.api.Test;
import ru.job4j.storage.model.Food;
import ru.job4j.storage.store.Shop;
import ru.job4j.storage.store.Store;
import ru.job4j.storage.store.Trash;
import ru.job4j.storage.store.Warehouse;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenDistribution() {
        List<Store> storeList = List.of(new Warehouse(), new Shop(), new Trash());
        ControlQuality control = new ControlQuality(storeList);
        Food firstFood = new Food("Сыр первый", LocalDate.of(2024, Month.JULY, 25),
                LocalDate.of(2024, Month.JUNE, 25), 135.50);
        Food secondFood = new Food("Сыр второй", LocalDate.of(2024, Month.JULY, 18),
                LocalDate.of(2024, Month.JUNE, 18), 135.50);
        Food thirdFood = new Food("Сыр третий", LocalDate.of(2024, Month.JULY, 3),
                LocalDate.of(2024, Month.JUNE, 3), 150.0);
        Food fourthFood = new Food("Сыр четвертый", LocalDate.of(2024, Month.JUNE, 26),
                LocalDate.of(2024, Month.JUNE, 1), 135.50);
        control.distribution(firstFood);
        control.distribution(secondFood);
        control.distribution(thirdFood);
        control.distribution(fourthFood);
        assertThat(storeList.get(0).findAll()).hasSize(1);
        assertThat(storeList.get(1).findAll()).hasSize(2);
        assertThat(storeList.get(2).findAll()).hasSize(1);
    }
}