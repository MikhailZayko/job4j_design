package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithComment() {
        String path = "data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect")).isEqualTo("org.hibernate.dialect.PostgreSQLDialect");
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password=");
    }

    @Test
    void whenIllegalArg1() {
        String path = "data/illegal_arg_1.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("key=value pattern violation");
    }

    @Test
    void whenIllegalArg2() {
        String path = "data/illegal_arg_2.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("key=value pattern violation");
    }

    @Test
    void whenIllegalArg3() {
        String path = "data/illegal_arg_3.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("key=value pattern violation");
    }
}