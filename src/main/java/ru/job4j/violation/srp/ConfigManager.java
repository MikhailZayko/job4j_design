package ru.job4j.violation.srp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Этот класс выполняет две задачи: управление настройками приложения и их сохранение в файл.
 * Эти задачи лучше разделить на два класса: один для управления настройками, другой для их сохранения.
 */

public class ConfigManager {

    private final Properties properties;

    public ConfigManager() {
        properties = new Properties();
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            properties.store(writer, "App Settings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
