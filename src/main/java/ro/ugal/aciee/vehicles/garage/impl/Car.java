package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class Car extends RollingVehicle {

    private boolean isRadioOn;

    private boolean isStorageFull;

    public Car() {
        super();
    }

    public Car(boolean isRadioOn, boolean isStorageFull) {
        super();
        this.isRadioOn = isRadioOn;
        this.isStorageFull = isStorageFull;
    }

    public Car(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, boolean isRadioOn, boolean isStorageFull) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.isRadioOn = isRadioOn;
        this.isStorageFull = isStorageFull;
    }

    public boolean isRadioOn() {
        return isRadioOn;
    }

    public void setRadioOn(boolean isRadioOn) {
        this.isRadioOn = isRadioOn;
    }

    public boolean isStorageFull() {
        return isStorageFull;
    }

    public void setStorageFull(boolean isStorageFull) {
        this.isStorageFull = isStorageFull;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 10.0;

        if (this.isStorageFull) {
            basePrice *= 2;
        }

        if (this.electric) {
            basePrice *= 0.8;
        }

        basePrice *= this.horsePower / 100.0;

        basePrice *= this.maxSpeedKmh / 100.0 * 2.0;

        return basePrice;
    }

}
