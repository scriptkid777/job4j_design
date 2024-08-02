package ru.job4j.it;

import java.util.Random;

public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("PID процесса: " + ProcessHandle.current().pid());
        int length = 100;
        String[] data = new String[1_00_000];
        for (int i = 0; ; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
        }
    }
}

