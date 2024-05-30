package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when6ThenFizz() {
        assertThat(Fool.correctAnswer(6)).isEqualTo("Fizz");
    }

    @Test
    void when10ThenBuzz() {
        assertThat(Fool.correctAnswer(10)).isEqualTo("Buzz");
    }

    @Test
    void when30ThenFizzBuzz() {
        assertThat(Fool.correctAnswer(30)).isEqualTo("FizzBuzz");
    }

    @Test
    void when98Then98() {
        assertThat(Fool.correctAnswer(98)).isEqualTo("98");
    }
}