package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;

/*
Нарушение: Класс `Library` управляет списком книг, печатает их и сохраняет данные в файл.
Это несколько обязанностей.
 */
public class Library {
    private List<String> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public void printBooks() {
        for (String book : books) {
            System.out.println("Book: " + book);
        }
    }

    public void saveToFile(String filename) {
        /* Логика сохранения библиотеки в файл   */
        System.out.println("Saving library to file: " + filename);
    }
}
