package ru.job4j.lsp.store;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.service.ExpirationDateCheck;

public class Shop extends AbstractStore {
ExpirationDateCheck dateCheck = new ExpirationDateCheck();
    @Override
    public boolean checkDate(Food food) {
        boolean result = false;
        double usedPercent = dateCheck.calculatePercent(food);
        if (usedPercent >= 25 && usedPercent <= 75) {
         result = true;
        } else if (usedPercent > 75 && usedPercent < 100) {
             addDiscount(food);
             result = true;
        }
        return result;
    }

    private void addDiscount(Food food) {
       food.setDiscount(20);
        food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100);
    }
}
