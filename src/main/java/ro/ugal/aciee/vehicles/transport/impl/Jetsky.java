package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.AquaVehicle;

public class Jetsky extends AquaVehicle {
    private int amountOfPilots;
    private double loudnessl;

    public Jetsky() {
        super();
    }

    public Jetsky(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int amountOfPilots, double loudnessl) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
        this.amountOfPilots = amountOfPilots;
        this.loudnessl = loudnessl;
    }

    public Jetsky( Jetsky other) {
        super(other);
        this.amountOfPilots = other.amountOfPilots;
        this.loudnessl = other.loudnessl;
    }

    public int getAmountOfPilots() {
        return amountOfPilots;
    }

    public void setAmountOfPilots(int amountOfPilots) {
        this.amountOfPilots = amountOfPilots;
    }

    public double getLoudnessl() {
        return loudnessl;
    }

    public void setLoudnessl(double loudnessl) {
        this.loudnessl = loudnessl;
    }

    @Override
    public String toString() {
        return "Jetsky{" +
                "amountOfPilots=" + amountOfPilots +
                ", loudnessl=" + loudnessl +
                '}';
    }
}

