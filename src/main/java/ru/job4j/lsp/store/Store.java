package ru.job4j.lsp.store;

import ru.job4j.lsp.model.Food;

import java.util.List;

public interface Store {
    boolean add(Food food);
    List<Food> findAll();
    boolean checkDate(Food food);
}
