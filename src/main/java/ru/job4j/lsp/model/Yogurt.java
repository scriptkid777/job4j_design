package ru.job4j.lsp.model;

import java.time.LocalDate;

public class Yogurt  extends Food {
    public Yogurt(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}
