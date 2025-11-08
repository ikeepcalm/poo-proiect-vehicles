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

    public Motorcycle(double engineCc, boolean sportBike, int maxSpeedKmh) {
        super();
        this.engineCc = engineCc;
        this.sportBike = sportBike;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Motorcycle(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, double engineCc, boolean sportBike) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.engineCc = engineCc;
        this.sportBike = sportBike;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public double getEngineCc() {
        return engineCc;
    }

    public void setEngineCc(double engineCc) {
        this.engineCc = engineCc;
    }

    public boolean isSportBike() {
        return sportBike;
    }

    public void setSportBike(boolean sportBike) {
        this.sportBike = sportBike;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrise = 5.0;

        if (this.sportBike) {
            basePrise *= 1.5;
        }

        if (this.electric) {
            basePrise *= 0.9;
        }

        basePrise *= this.horsePower / 80.0;

        basePrise *= this.maxSpeedKmh / 120.0;

        return basePrise;
    }
}
