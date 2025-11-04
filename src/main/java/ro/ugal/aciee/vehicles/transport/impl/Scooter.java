package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.RollingVehicle;

public class Scooter extends RollingVehicle {

    private boolean electric;
    private double batteryKWh;
    private int maxSpeedKmh;

    public Scooter(boolean electric) {
        this.electric = electric;
    }

    public Scooter(double batteryKWh) {
        this.batteryKWh = batteryKWh;
    }

    public Scooter(int maxSpeedKmh) {
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
    public String toString() {
        return "Scooter{" +
                "electric=" + electric +
                ", batteryKWh=" + batteryKWh +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }


}
