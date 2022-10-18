package ru.job4j.io;

import java.io.*;
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

    public static void save(List<String> log, String file) {
       try (PrintWriter out = new PrintWriter(
             new BufferedOutputStream(
                     new FileOutputStream(file)
             ))) {
           for (String line : log) {
               out.printf("%s%n", line);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
    }


    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        save(log, "404.txt");
        for (String line : log) {
            System.out.println(line);
        }
    }
}
