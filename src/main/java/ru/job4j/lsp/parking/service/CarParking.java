package ru.job4j.lsp.parking.service;

import ru.job4j.lsp.parking.model.Vehicle;

public class CarParking implements Parking {

    private int placesCar;

    private int placesTruck;

    public CarParking(int placesCar, int placesTruck) {
        this.placesCar = placesCar;
        this.placesTruck = placesTruck;
    }

    @Override
    public boolean vehicleParking(Vehicle vehicle) {
        boolean rsl = false;
        int size = vehicle.size();
        if (size == 1 && placesCar > 0) {
            placesCar--;
            rsl = true;
        } else if (size > 1 && placesTruck > 0) {
            placesTruck--;
            rsl = true;
        } else if (size > 1 && placesCar >= size) {
            placesCar -= size;
            rsl = true;
        }
        return rsl;
    }
}