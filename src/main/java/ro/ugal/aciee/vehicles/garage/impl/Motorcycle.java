package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class Motorcycle extends RollingVehicle {

    private double engineCc;
    private boolean sportBike;
    private int maxSpeedKmh;

    public Motorcycle() {
        super();
    }

    public Motorcycle(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower, double engineCc) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, numberOfWheels, isElectric, horsePower);
        this.engineCc = engineCc;
    }

    public double getEngineCc() {
        return engineCc;
    }

    public void setEngineCc(double engineCc) {
        this.engineCc = engineCc;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public void accelerate() {
        super.accelerate();
        this.setSpeed(this.getSpeed() + 15);
    }

    @Override
    public void brake() {
        super.brake();
        this.setSpeed(0);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "engineCc=" + engineCc +
                ", sportBike=" + sportBike +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }
}
