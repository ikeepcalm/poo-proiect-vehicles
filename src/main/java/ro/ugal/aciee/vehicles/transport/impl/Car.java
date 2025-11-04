package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.RollingVehicle;

public class Car extends RollingVehicle {

    private boolean isRadioOn;

    private boolean isStorageFull;

    public Car() {
        super();
    }

    public Car(Car other) {
        super(other);
        this.isRadioOn = other.isRadioOn;
        this.isStorageFull = other.isStorageFull;
    }

    public Car(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower, boolean isRadioOn) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, numberOfWheels, isElectric, horsePower);
        this.isRadioOn = isRadioOn;
    }

    public boolean isRadioOn() {
        return isRadioOn;
    }

    public void setRadioOn(boolean isRadioOn) {
        this.isRadioOn = isRadioOn;
    }

    public boolean isStorageFull() {
        return isStorageFull;
    }

    public void setStorageFull(boolean isStorageFull) {
        this.isStorageFull = isStorageFull;
    }

    @Override
    public String toString() {
        return "Car{" +
               "isRadioOn=" + isRadioOn +
               ", isStorageFull=" + isStorageFull +
               '}';
    }
}
