package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class Scooter extends RollingVehicle {

    private boolean electric;
    private double batteryKWh;
    private int maxSpeedKmh;

    public Scooter() {
        super();
    }

    public Scooter(RollingVehicle other, boolean electric, double batteryKWh, int maxSpeedKmh) {
        super(other);
        this.electric = electric;
        this.batteryKWh = batteryKWh;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Scooter(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower, boolean electric) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, numberOfWheels, isElectric, horsePower);
        this.electric = electric;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public double getBatteryKWh() {
        return batteryKWh;
    }

    public void setBatteryKWh(double batteryKWh) {
        this.batteryKWh = batteryKWh;
    }

    @Override
    public boolean isElectric() {
        return electric;
    }

    @Override
    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    @Override
    public void accelerate() {
        super.accelerate();
        this.setSpeed(this.getSpeed() + 8);
        if (this.electric && this.batteryKWh > 0.1) {
            this.batteryKWh -= 0.1;
        }
    }

    @Override public void brake() {
            super.brake();
            this.setSpeed(0);
            if (this.electric && this.batteryKWh < 100) {
                this.batteryKWh += 0.05;
            }
        }

    @Override
    public String toString() {
        return "Scooter{" +
                "electric=" + electric +
                ", batteryKWh=" + String.format("%.2f", batteryKWh) +
                ", maxSpeedKmh=" + maxSpeedKmh +
                ", speed=" + getSpeed() +
                '}';
    }
}
