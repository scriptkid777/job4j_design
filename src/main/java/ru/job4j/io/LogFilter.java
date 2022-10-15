package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> array = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            array = in.lines().filter(s -> s.contains(" 404 ")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        for (String line : log) {
            System.out.println(line);
        }
    }
}
