package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String argFilter = argsName.get("filter");
        String argDel = argsName.get("delimiter");
        String argPath = argsName.get("path");
        String argOut = argsName.get("out");
        String[] filters = argFilter.split(",");
        int[] indexes = new int[filters.length];
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(argPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(argOut))) {
            Scanner scanner = new Scanner(reader).useDelimiter(",");
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split(argDel);
                for (int i = 0; i < lines.length; i++) {
                    for (int j = 0; j < filters.length; j++) {
                        if (lines[i].equals(filters[j])) {
                            indexes[j] = i;
                        }
                    }
                }
                StringJoiner joiner = new StringJoiner(argDel);
                for (int index : indexes) {
                    joiner.add(lines[index]);
                }
                list.add(joiner.toString());
                list.add(System.lineSeparator());
            }
            for (String line : list) {
                if (argOut.equals("stdout")) {
                    System.out.println(line);
                } else {
                    writer.write(line);
                }
            }
            } catch (IOException e) {
             e.printStackTrace();
        }
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
        String argFilter = args.get("filter");
        String argDel = args.get("delimiter");
        String argPath = args.get("path");
        String argOut = args.get("out");

        if (!Files.exists(Path.of(argPath))) {
            throw new IllegalArgumentException("File does not Exists!");
        }
        if (!argPath.contains(".csv")) {
            throw new IllegalArgumentException("Specified incorrect path");
        }
        if (!argDel.contains(";") || argDel.length() > 1) {
            throw new IllegalArgumentException("Specified incorrect delimiter");
        }
        if (!(argOut.contains("stdout") || argOut.contains(".csv"))) {
            throw new IllegalArgumentException("Specified incorrect path");
        }
        if (argFilter.split(",").length < 1) {
            throw new IllegalArgumentException("There must be at least one filter");
        }
    }
}