package ru.job4j.lsp.service;

import ru.job4j.lsp.model.Food;

import java.time.LocalDate;
import static  java.time.temporal.ChronoUnit.DAYS;


public class ExpirationDateCheck  implements DateChecker {
    /**
     * Метод проверяет  срок годности продукта
     * @return значение израсходованности в процентах
     */
    @Override
    public double calculatePercent(Food food) {
        double percent = 100;
        LocalDate now = LocalDate.now();
        LocalDate createDate = food.getCreateDate();
        LocalDate expireDate = food.getExpiryDate();
        if (DAYS.between(now, expireDate) > 0) {
         double amountDay = DAYS.between(createDate, expireDate);
         double usedDay  = DAYS.between(createDate, now);
         percent = Math.round((usedDay / amountDay) * 100);
        }
        return percent;
    }
}
