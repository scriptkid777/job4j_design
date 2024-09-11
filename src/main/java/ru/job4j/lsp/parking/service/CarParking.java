package ru.job4j.lsp.parking.service;

import ru.job4j.lsp.parking.model.Vehicle;

public class CarParking implements Parking {

    private  int placesCar;

    private  int placesTruck;

    public CarParking(int placesCar, int placesTruck) {
        this.placesCar = placesCar;
        this.placesTruck = placesTruck;
    }

    @Override
    public boolean vehicleParking(Vehicle vehicle) {
        return false;
    }
}
