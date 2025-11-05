package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.AeroVehicle;


public class Jetplane extends AeroVehicle {
    private double maxJ;
    private boolean isNoseSharp;

    public Jetplane() {
        super();
    }

    public Jetplane(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int loadCapacity, int maxHeight, int amountOfEngines, boolean isNoseSharp, double maxJ) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, loadCapacity, maxHeight, amountOfEngines);
        this.isNoseSharp = isNoseSharp;
        this.maxJ = maxJ;
    }

    public Jetplane(Jetplane other) {
        super(other);
        this.maxJ = other.maxJ;
        this.isNoseSharp = other.isNoseSharp;
    }

    public boolean isNoseSharp() {
        return isNoseSharp;
    }

    public void setNoseSharp(boolean noseSharp) {
        isNoseSharp = noseSharp;
    }

    public double getMaxJ() {
        return maxJ;
    }

    public void setMaxJ(double maxJ) {
        this.maxJ = maxJ;
    }

    @Override
    public String toString() {
        return "Jetplane{" +
                "maxJ=" + maxJ +
                ", isNoseSharp=" + isNoseSharp +
                '}';
    }
}
