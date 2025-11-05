package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.NavalVehicle;

public class Jetsky extends NavalVehicle {

    private int amountOfPilots;
    private double loudness;

    public Jetsky() {
        super();
    }

    public Jetsky(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int amountOfPilots, double loudness) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
        this.amountOfPilots = amountOfPilots;
        this.loudness = loudness;
    }

    public Jetsky(Jetsky other) {
        super(other);
        this.amountOfPilots = other.amountOfPilots;
        this.loudness = other.loudness;
    }

    public int getAmountOfPilots() {
        return amountOfPilots;
    }

    public void setAmountOfPilots(int amountOfPilots) {
        this.amountOfPilots = amountOfPilots;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    @Override
    public String toString() {
        return "Jetsky{" +
               "amountOfPilots=" + amountOfPilots +
               ", loudnessl=" + loudness +
               '}';
    }
}

