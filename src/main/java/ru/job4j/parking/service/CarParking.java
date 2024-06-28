package ru.job4j.parking.service;

import ru.job4j.parking.model.Vehicle;

public class CarParking implements Parking {

    private int placesForCars;

    private int placesForTrucks;

    public CarParking(int placesForCars, int placesForTrucks) {
        this.placesForCars = placesForCars;
        this.placesForTrucks = placesForTrucks;
    }

    @Override
    public boolean vehicleParking(Vehicle vehicle) {
        boolean result = false;
        int size = vehicle.size();
        if (size == 1 && placesForCars > 0) {
            placesForCars--;
            result = true;
        } else if (size > 1 && placesForTrucks > 0) {
            placesForTrucks--;
            result = true;
        } else if (size > 1 && placesForCars >= size) {
            placesForCars -= size;
            result = true;
        }
        return result;
    }
}
