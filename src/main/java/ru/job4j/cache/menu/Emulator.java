package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emulator {

    private static final String MENU = """
            1. Указать кэшируемую директорию
            2. Загрузить содержимое файла в кэш
            3. Получить содержимое файла из кэша
            4. Выход
            Выберите опцию:\s""";

    private static DirFileCache cache;

    private static List<String> uploadedFiles = new ArrayList<>();

    private static void start(Scanner scanner) {
        boolean running = true;
        String dir = "";
        String fileToLoad;
        String fileToGet;
        while (running) {
            System.out.print(MENU);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Введите путь к кэшируемой директории: ");
                    dir = scanner.nextLine();
                    validateDir(dir);
                    cache = new DirFileCache(dir);
                    break;
                case 2:
                    System.out.print("Введите имя файла для загрузки в кэш: ");
                    fileToLoad = scanner.nextLine();
                    if (cache != null) {
                        validateFile(dir, fileToLoad);
                        uploadedFiles.add(fileToLoad);
                        cache.get(fileToLoad);
                        System.out.println("Файл загружен в кэш.");
                    } else {
                        System.out.println("Сначала укажите кэшируемую директорию.");
                    }
                    break;
                case 3:
                    System.out.print("Введите имя файла для получения из кэша: ");
                    fileToGet = scanner.nextLine();
                    if (cache == null) {
                        System.out.println("Сначала укажите кэшируемую директорию.");
                    } else if (!uploadedFiles.contains(fileToGet)) {
                        System.out.println("Файл не загружен в кэш.");
                    } else {
                        String content = cache.get(fileToGet);
                        System.out.println("Содержимое файла: " + content);
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void validateDir(String dir) {
        Path path = Path.of(dir);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("This directory does not exist");
        }
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("This is not a directory");
        }
    }

    private static void validateFile(String dir, String file) {
        Path path = Path.of(dir).resolve(file);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("This file does not exist");
        }
        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException("This is not a file");
        }
        if (!Files.isReadable(path)) {
            throw new IllegalArgumentException("The file is not readable");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
    }

}