package ru.job4j.lsp.store;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.service.ExpirationDateCheck;

public class Trash extends AbstractStore {
    ExpirationDateCheck dateCheck = new ExpirationDateCheck();

    @Override
    public boolean checkDate(Food food) {
        return dateCheck.calculatePercent(food) == 100;
    }
}
