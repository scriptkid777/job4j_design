package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
                String[] lines = text.toString().split(System.lineSeparator());
                for (String line : lines) {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0) {
                        System.out.println(number + " - четное число");
                    } else {
                        System.out.println(number + " - нечетное число");
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
