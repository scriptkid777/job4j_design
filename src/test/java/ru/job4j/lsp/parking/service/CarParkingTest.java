package ru.job4j.lsp.parking.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.lsp.parking.model.PassengerCar;
import ru.job4j.lsp.parking.model.Truck;

import static org.assertj.core.api.Assertions.assertThat;

class CarParkingTest {

    @Test
    @Disabled("Удалить аннотацию после реализации")
    void whenVehicleParking() {
   Parking parking = new CarParking(6, 1);
   assertThat(parking.vehicleParking(new PassengerCar())).isTrue();
   assertThat(parking.vehicleParking(new Truck(3))).isTrue();
   assertThat(parking.vehicleParking(new Truck(5))).isTrue();
   assertThat(parking.vehicleParking(new PassengerCar())).isFalse();
   assertThat(parking.vehicleParking(new Truck(4))).isFalse();
    }

}