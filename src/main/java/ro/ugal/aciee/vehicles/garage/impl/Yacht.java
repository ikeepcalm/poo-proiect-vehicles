package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

public class Yacht extends NavalVehicle {

    private boolean hasPool;
    private boolean sailsRaised;

    public Yacht() {
        super();
    }

    public Yacht(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, boolean canOperateInStorm, boolean hasPool, boolean sailsRaised) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, canOperateInStorm);
        this.hasPool = hasPool;
        this.sailsRaised = sailsRaised;
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
    public double getDailyRentalPrice(){
        double basePrice = 500.0;

        if(hasPool){
            basePrice *= 1.3;
        }

        if(canOperateInStorm){
            basePrice *= 2;
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return "Yacht{" +
               "hasPool=" + hasPool +
               ", sailsRaised=" + sailsRaised +
               '}';
    }
}


