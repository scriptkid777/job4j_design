package ru.job4j.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.lsp.model.Bread;
import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Yogurt;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {
    @Test
    public void whenPriceChange() {
        Store store = new Shop();
        LocalDate now = LocalDate.now();
        Food food = new Yogurt("Danone", now.minusDays(4), now.plusDays(1), 100);
        store.checkDate(food);
        assertThat(food.getPrice()).isEqualTo(80);
    }

    @Test
    public void whenAddFood3Then2TrueAnd1False() {
        Store store = new Shop();
        LocalDate now = LocalDate.now();
        Food food1 = new Yogurt("Danone", now.minusDays(2), now.plusDays(7), 100);
        Food food2 = new Bread("Bread", now.minusDays(2), now.plusDays(6), 50);
        Food food3 = new Food("Cucumber", now.minusDays(2), now.plusDays(2), 50);
        assertThat(store.checkDate(food1)).isFalse();
        assertThat(store.checkDate(food2)).isTrue();
        assertThat(store.checkDate(food3)).isTrue();
    }
}