package ru.job4j.lsp.service;

import org.junit.jupiter.api.Test;
import ru.job4j.lsp.model.Bread;
import ru.job4j.lsp.model.Yogurt;
import ru.job4j.lsp.model.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ExpirationDateCheckTest {

    @Test
    public void wheExpiredThen100() {
        DateChecker checker = new ExpirationDateCheck();
        LocalDate now = LocalDate.now();
        LocalDate expired = LocalDate.now().minusDays(3);
        Food food = new Yogurt("Danone", now, expired, 75);
        double result = checker.calculatePercent(food);
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void  whenExpiredThen75() {
        DateChecker checker = new ExpirationDateCheck();
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expired = LocalDate.now().plusDays(6);
        Food food = new Bread("Black", created, expired, 15);
        double result = checker.calculatePercent(food);
        assertThat(result).isEqualTo(25);
    }

    @Test
    public void whenNotExpiredThen50() {
        DateChecker checker = new ExpirationDateCheck();
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expired = LocalDate.now().plusDays(2);
        Food food = new Food("Cucumbers", created, expired, 100);
        double result = checker.calculatePercent(food);
        assertThat(result).isEqualTo(50);
    }
}