package ru.job4j.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.lsp.model.Bread;
import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Yogurt;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    public void whenAdd4FoodThen2TrueAnd2False() {
        Store store = new Warehouse();
        LocalDate now = LocalDate.now();
        Food food1 = new Yogurt("Danone", now, now.plusDays(10), 100);
        Food food2 = new Food("Cucumber", now.minusDays(2), now.plusDays(7), 100);
        Food food3 = new Bread("White", now.minusDays(2), now.plusDays(6), 50);
        Food food4 = new Bread("Black", now.minusDays(2), now.plusDays(2), 50);
        assertThat(store.checkDate(food1)).isTrue();
        assertThat(store.checkDate(food2)).isTrue();
        assertThat(store.checkDate(food3)).isFalse();
        assertThat(store.checkDate(food4)).isFalse();
    }
}