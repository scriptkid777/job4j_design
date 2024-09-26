package ru.job4j.lsp.service;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality implements ControlService {
    
    private final List<Store> storeList;
    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    @Override
    public void resort() {
        List<Food> tempList = new ArrayList<>();
        for (Store store : storeList) {
            tempList.addAll(store.findAll());
        }
        tempList.forEach(this::distribute);
    }

    @Override
    public void distribute(Food food) {
        for (Store store:storeList) {
            store.add(food);
        }


    }
}
