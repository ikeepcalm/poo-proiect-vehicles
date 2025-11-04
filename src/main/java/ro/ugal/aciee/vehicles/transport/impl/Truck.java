package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.RollingVehicle;

public class Truck extends RollingVehicle {

    private boolean isTrailerAttached;

    public Truck() {
        super();
    }

    public Truck(Truck other) {
        super(other);
        this.isTrailerAttached = other.isTrailerAttached;
    }

    public Truck(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower, boolean isTrailerAttached) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, numberOfWheels, isElectric, horsePower);
        this.isTrailerAttached = isTrailerAttached;
    }

    public boolean isTrailerAttached() {
        return isTrailerAttached;
    }

    public void setTrailerAttached(boolean trailerAttached) {
        isTrailerAttached = trailerAttached;
    }

    @Override
    public String toString() {
        return "Truck{" +
               "isTrailerAttached=" + isTrailerAttached +
               '}';
    }
}
