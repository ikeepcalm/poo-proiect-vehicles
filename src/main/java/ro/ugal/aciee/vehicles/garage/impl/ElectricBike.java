package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class ElectricBike extends RollingVehicle {

    private int range;
    private String address;

    public ElectricBike() {
        super();
    }

    public ElectricBike(int range, String address) {
        this.range = range;
        this.address = address;
    }

    public ElectricBike(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, int range, String address) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
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
    public double getDailyRentalPrice() {
        double DefaulPrice = 20;
        if (this.range == 100) {
            DefaulPrice *= 0.5;
        }
        if (this.color == VehicleColor.PINK) {
            DefaulPrice *= 10;
        }
        return  DefaulPrice;

    }

}