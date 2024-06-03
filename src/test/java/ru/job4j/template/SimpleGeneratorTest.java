package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов.")
class SimpleGeneratorTest {

    @Test
    public void whenTheArgumentsAreCorrect() {
        Generator generator = new SimpleGenerator();
        String template = "My name is ${name} and I'm from ${country}";
        Map<String, String> args = Map.of(
                "name", "Misha",
                "country", "Russia"
        );
        String result = generator.produce(template, args);
        String expected = "My name is Misha and I'm from Russia";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenTheKeysAreNotEnoughThenGetException() {
        Generator generator = new SimpleGenerator();
        String template = "My name is ${name} and I'm from ${country}";
        Map<String, String> args = Map.of("country", "Russia");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenThereAreExtraKeysThenGetException() {
        Generator generator = new SimpleGenerator();
        String template = "My name is ${name} and I'm from ${country}";
        Map<String, String> args = Map.of(
                "name", "Misha",
                "country", "Russia",
                "language", "Java"
        );
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}