package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;

public class Airplane extends AeroVehicle {

    private boolean isFragileCargo;
    private double wingspan;

    public Airplane() {
        super();
    }

    public Airplane(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int loadCapacity, int maxHeight, int amountOfEngines, double wingspan, boolean isFragileCargo) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking, loadCapacity, maxHeight, amountOfEngines);
        this.wingspan = wingspan;
        this.isFragileCargo = isFragileCargo;
    }

    public Airplane(AeroVehicle other, double wingspan, boolean isFragileCargo) {
        super(other);
        this.wingspan = wingspan;
        this.isFragileCargo = isFragileCargo;
    }

    public boolean isFragileCargo() {
        return isFragileCargo;
    }

    public void setFragileCargo(boolean fragileCargo) {
        isFragileCargo = fragileCargo;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return "Airplane{" +
               "isFragileCargo=" + isFragileCargo +
               ", wingspan=" + wingspan +
               '}';
    }
}
