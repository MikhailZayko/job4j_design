package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void whenNamesArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    @Test
    void whenNameDoesNotContainEqualSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key=value", "key@value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("key@value does not contain the symbol '='");
    }

    @Test
    void whenNameStartWithEqualSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key=value", "=key|value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("=key|value does not contain a key");
    }

    @Test
    void whenNameEndWithEqualSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Key=Value", "Key/value="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Key/value= does not contain a value");
    }
}