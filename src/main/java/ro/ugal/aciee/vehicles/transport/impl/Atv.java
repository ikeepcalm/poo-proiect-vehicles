package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.RollingVehicle;

public class Atv extends RollingVehicle {

    private int size;
    private boolean spareWheel;

    public Atv(int size, boolean spareWheel) {
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public Atv(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower, int size, boolean spareWheel) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, numberOfWheels, isElectric, horsePower);
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public Atv() {
    }

    public Atv(boolean spareWheel, int size) {
        this.spareWheel = spareWheel;
        this.size = size;
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
    public String toString() {
        return "Atv{" +
                "size=" + size +
                ", spareWheel=" + spareWheel +
                '}';
    }
}
