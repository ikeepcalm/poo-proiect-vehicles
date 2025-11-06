package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class ElectricBike extends RollingVehicle {

    private int range;
    private String address;

    public ElectricBike() {
    }

    public ElectricBike(int range, String address) {
        this.range = range;
        this.address = address;
    }

    public ElectricBike(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower, int range, String address) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, numberOfWheels, isElectric, horsePower);
        this.range = range;
        this.address = address;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void accelerate() {
        super.accelerate();
        this.setSpeed(10);
    }

    @Override
    public void brake() {
        super.brake();
        this.setSpeed(0);
    }

    @Override
    public String toString() {
        return "ElictricBike{" +
               "range=" + range +
               ", address='" + address + '\'' +
               '}';
    }
}
