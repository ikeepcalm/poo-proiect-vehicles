package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class Truck extends RollingVehicle {

    private boolean isTrailerAttached;

    public Truck() {
        super();
    }

    public Truck(boolean electric, int horsePower, int maxSpeedKmh, boolean isTrailerAttached) {
        super(electric, horsePower, maxSpeedKmh);
        this.isTrailerAttached = isTrailerAttached;
    }

    public Truck(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, boolean isTrailerAttached) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.isTrailerAttached = isTrailerAttached;
    }

    public boolean isTrailerAttached() {
        return isTrailerAttached;
    }

    public void setTrailerAttached(boolean trailerAttached) {
        isTrailerAttached = trailerAttached;
    }

    @Override
    public String toString() {
        return "Truck{" +
               "isTrailerAttached=" + isTrailerAttached +
               '}';
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 15.0;

        if (this.isTrailerAttached) {
            basePrice *= 2;
        }

        if (this.electric) {
            basePrice *= 0.7;
        }

        basePrice *= this.horsePower / 50.0;

        return basePrice;
    }
}
