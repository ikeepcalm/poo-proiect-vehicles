package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

public class Atv extends RollingVehicle {

    private int size;
    private boolean spareWheel;

    public Atv() {
        super();
    }


    public Atv(int size, boolean spareWheel) {
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public Atv(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, int size, boolean spareWheel) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
      this.size = size;
    }

    public boolean isSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(boolean spareWheel) {
        this.spareWheel = spareWheel;
    }


    @Override
    public double getDailyRentalPrice() {
        double DefaulPrice = 100;
        if (this.spareWheel == true) {
            DefaulPrice *= 2;
        }
        if (this.size > 4) {
            DefaulPrice += 100;

        }
        return DefaulPrice;
    }
}





