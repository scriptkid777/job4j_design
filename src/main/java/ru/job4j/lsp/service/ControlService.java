package ru.job4j.lsp.service;

import ru.job4j.lsp.model.Food;

public interface ControlService extends Sorter {
    void  distribute(Food food);
}
