package ru.job4j.srp;

/*
Нарушение: Класс `User` отвечает за сохранение данных,
отправку электронных писем и печать информации о пользователе.
 Это несколько обязанностей.
 */
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void save() {
        /* Логика сохранения пользователя в базу данных */
    }

    public void sendEmail(String message) {
        /* Логика отправки email пользователю */
    }

    public void printUserDetails() {
        /* Логика печати информации о пользователе */
        System.out.println("Name: " + name + ", Email: " + email);
    }
}
