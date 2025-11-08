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

    public Scooter(boolean electric, double batteryKWh, int maxSpeedKmh) {
        super();
        this.electric = electric;
        this.batteryKWh = batteryKWh;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Scooter(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, double batteryKWh) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.electric = electric;
        this.batteryKWh = batteryKWh;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public double getBatteryKWh() {
        return batteryKWh;
    }

    public void setBatteryKWh(double batteryKWh) {
        this.batteryKWh = batteryKWh;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 3.0;

        if (this.electric) {
            basePrice *= 0.85;
        }

        if (this.batteryKWh > 2.0) {
            basePrice *= 1.3;
        }

        basePrice *= this.horsePower / 50.0;

        basePrice *= this.maxSpeedKmh / 60.0;

        return basePrice;

    }
}
