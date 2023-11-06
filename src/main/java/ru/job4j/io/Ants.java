package ru.job4j.io;

public class Ants {
    public static int calculate(int n, int left, int right) {
        int minDistance = Math.min(left, n - right);
        return Math.max(minDistance, 1);
    }

    public static void main(String[] args) {
        int n = 3; // длина доски
        int left = 3; // позиция муравья, который движется влево
        int right = 1; // позиция муравья, который движется вправо

        int falloutRound = calculate(n, left, right);
        System.out.println("Количество раундов до выпадения первого муравья: " + falloutRound);
    }
}

