package ru.job4j.lsp.store;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.service.ExpirationDateCheck;

public class Warehouse extends AbstractStore {
    ExpirationDateCheck dataChecker = new ExpirationDateCheck();

    @Override
    public boolean checkDate(Food food) {
        return dataChecker.calculatePercent(food) < 25;
    }
}
