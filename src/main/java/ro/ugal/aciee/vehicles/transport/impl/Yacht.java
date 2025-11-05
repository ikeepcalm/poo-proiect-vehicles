package ro.ugal.aciee.vehicles.transport.impl;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.NavalVehicle;

public class Yacht extends NavalVehicle {

    private boolean hasPool;
    private boolean sailsRaised;

    public Yacht() {
        super();
    }

    public Yacht(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, boolean sailsRaised, boolean hasPool) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
        this.sailsRaised = sailsRaised;
        this.hasPool = hasPool;
    }

    public Yacht(Yacht other) {
        super(other);
        this.hasPool = other.hasPool;
        this.sailsRaised = other.sailsRaised;
    }

    public boolean getIsHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean getIsSailsRaised() {
        return sailsRaised;
    }

    public void setSailsRaised(boolean sailsRaised) {
        this.sailsRaised = sailsRaised;
    }

    @Override
    public String toString() {
        return "Yacht{" +
               "hasPool=" + hasPool +
               ", sailsRaised=" + sailsRaised +
               '}';
    }
}


