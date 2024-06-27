package ru.job4j.parking.service;

import ru.job4j.parking.model.Vehicle;

public class CarParking implements Parking {

    private final int placesForCars;

    private final int placesForTrucks;

    public CarParking(int placesForCars, int placesForTrucks) {
        this.placesForCars = placesForCars;
        this.placesForTrucks = placesForTrucks;
    }

    @Override
    public boolean vehicleParking(Vehicle vehicle) {
        return false;
    }
}
