package ru.job4j.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("\"The arguments count should be \\\"4\\\"\"");
        }

        ArgsName argsName = ArgsName.of(args);
        checkArgs(argsName);
        handle(argsName);

    }

    public static void checkArgs(ArgsName args) {
        if (!Files.exists(Path.of(args.get("path")))) {
            throw new IllegalArgumentException("File does not Exists!");
        }
    }
}