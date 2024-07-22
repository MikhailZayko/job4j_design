package ru.job4j.storage.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.storage.model.Food;
import ru.job4j.storage.store.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
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

    @Test
    void whenResort() {
        Store testStore = new AbstractStore() {
            @Override
            public void add(Food food) {
                foodList.add(food);
            }
        };
        testStore.add(new Food("Сыр первый", LocalDate.of(2024, Month.AUGUST, 17),
                LocalDate.of(2024, Month.JULY, 17), 135.50));
        testStore.add(new Food("Сыр второй", LocalDate.of(2024, Month.AUGUST, 10),
                LocalDate.of(2024, Month.JULY, 10), 135.50));
        testStore.add(new Food("Сыр третий", LocalDate.of(2024, Month.JUNE, 26),
                LocalDate.of(2024, Month.JUNE, 1), 135.50));
        List<Store> storeList = List.of(new Warehouse(), new Shop(), new Trash(), testStore);
        ControlQuality control = new ControlQuality(storeList);
        control.resort();
        assertThat(storeList.get(0).findAll()).hasSize(1);
        assertThat(storeList.get(1).findAll()).hasSize(1);
        assertThat(storeList.get(2).findAll()).hasSize(1);
    }
}