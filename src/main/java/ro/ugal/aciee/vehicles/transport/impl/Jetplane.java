package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.AeroVehicle;


public class Jetplane extends AeroVehicle {

    private double maxG;
    private boolean sharpNose;

    public Jetplane() {
        super();
    }

    public Jetplane(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int loadCapacity, int maxHeight, int amountOfEngines, boolean sharpNose, double maxG) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, loadCapacity, maxHeight, amountOfEngines);
        this.sharpNose = sharpNose;
        this.maxG = maxG;
    }

    public Jetplane(Jetplane other) {
        super(other);
        this.maxG = other.maxG;
        this.sharpNose = other.sharpNose;
    }

    public boolean isSharpNose() {
        return sharpNose;
    }

    public void setSharpNose(boolean sharpNose) {
        this.sharpNose = sharpNose;
    }

    public double getMaxG() {
        return maxG;
    }

    public void setMaxG(double maxG) {
        this.maxG = maxG;
    }

    @Override
    public String toString() {
        return "Jetplane{" +
               "maxJ=" + maxG +
               ", isNoseSharp=" + sharpNose +
               '}';
    }
}
