package ru.job4j;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(checkValue(startAt++));
            var answer = input.nextLine();
            if (!checkValue(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static String checkValue(int value) {
        String result;
        if (value % 3 == 0 && value % 5 == 0) {
            result = "FizzBuzz";
        } else if (value % 3 == 0) {
            result = "Fizz";
        } else if (value % 5 == 0) {
            result = "Buzz";
        } else {
            result = String.valueOf(value);
        }
        return result;
    }
}