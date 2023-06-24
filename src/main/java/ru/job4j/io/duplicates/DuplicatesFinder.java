package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {

    public static void findDuplicate(Path path) throws IOException {
        DuplicatesVisitor duplVisit = new DuplicatesVisitor();
        Files.walkFileTree(path, duplVisit);
        duplVisit.getDuplicates().forEach((key, value) -> {
            if (value.size() > 1) {
                value.forEach(System.out::println);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Path root =  Path.of("./data");
        findDuplicate(root);
    }
}
