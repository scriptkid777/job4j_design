package ru.job4j.lsp.parking.model;

public class Truck implements Vehicle {

    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
