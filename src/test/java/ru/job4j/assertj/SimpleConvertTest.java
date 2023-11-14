package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "three", "five");
        assertThat(list).isNotEmpty()
                .contains("one", "five")
                .hasSize(4)
                .allMatch(s -> s.length() > 2)
                .first()
                .isEqualTo("one");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("seven", "eight", "five", "four", "one");
        assertThat(set).isNotNull()
                .hasSize(5)
                .contains("five", "eight")
                .noneMatch(s -> s.equals("two"))
                .filteredOn(s -> s.length() == 3)
                .last()
                .isEqualTo("one");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one", "seven", "eight", "five", "four");
        assertThat(map).isNotEmpty()
                .containsKeys("one", "seven", "five")
                .containsValues(0, 2, 3)
                .containsEntry("seven", 1)
                .hasSize(5);
    }
}