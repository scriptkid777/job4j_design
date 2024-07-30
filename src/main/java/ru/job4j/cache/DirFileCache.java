package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path absolutePath = FileSystems.getDefault().getPath(cachingDir, key);
        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (var reader = new BufferedReader(new FileReader(absolutePath.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла или директории не существует.");
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return result.toString();
    }
}
