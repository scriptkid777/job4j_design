package ru.job4j.io.duplicates;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> duplicates = new HashMap<>();

    public Map<FileProperty, List<Path>> getDuplicates() {
        return duplicates;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       FileProperty currentFile = new FileProperty(file.toFile().length(), file.getFileName().toString());
       if (!duplicates.containsKey(currentFile)) {
           duplicates.put(currentFile, new ArrayList<>());
           duplicates.get(currentFile).add(file);
       } else {
           duplicates.get(currentFile).add(file);
       }

        return FileVisitResult.CONTINUE;
    }
}
