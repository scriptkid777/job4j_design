package ru.job4j.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Yogurt;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
class TrashTest {
    @Test
    public void whenExpiredThenTrue() {
        LocalDate now = LocalDate.now();
        LocalDate earlier = now.minusDays(1);
        Food food = new Yogurt("Danone", now, earlier, 100);
        Store store = new Trash();
        assertThat(store.checkDate(food)).isTrue();
    }

    @Test
    public void whenNotExpiredThenFalse() {
        LocalDate now = LocalDate.now();
        LocalDate later = now.plusDays(1);
        Food food = new Yogurt("Danone", now, later, 100);
        Store store = new Trash();
        assertThat(store.checkDate(food)).isFalse();
    }

}