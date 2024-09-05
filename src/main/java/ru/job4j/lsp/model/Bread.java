package ru.job4j.lsp.model;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}
