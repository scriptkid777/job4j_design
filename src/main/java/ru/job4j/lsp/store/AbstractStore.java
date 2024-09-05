package ru.job4j.lsp.store;

import ru.job4j.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> store = new ArrayList<>();
    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (checkDate(food)) {
            store.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> findAll() {
        return store;
    }

    @Override
    public  abstract boolean checkDate(Food food);
}