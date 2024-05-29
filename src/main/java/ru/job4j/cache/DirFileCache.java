package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String result = null;
        Path path = Path.of(cachingDir).resolve(key);
        try {
            result = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}