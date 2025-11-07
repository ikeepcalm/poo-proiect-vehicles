package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;

public class Airplane extends AeroVehicle {

    private boolean isFragileCargo;
    private double wingspan;

    public Airplane() {
        super();
    }

    public Airplane(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, int maxHeight, int amountOfEngines, boolean isFragileCargo, double wingspan) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, maxHeight, amountOfEngines);
        this.isFragileCargo = isFragileCargo;
        this.wingspan = wingspan;
    }

    public Airplane(Airplane other) {
        super(other);
        this.isFragileCargo = other.isFragileCargo;
        this.wingspan = other.wingspan;
    }

    public boolean getIsFragileCargo() {
        return isFragileCargo;
    }

    public void setIsFragileCargo(boolean fragileCargo) {
        isFragileCargo = fragileCargo;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public double getDailyRentalPrice(){
        double basePrice = 1500.0;

        if(isFragileCargo){
            basePrice *= 1.8;
        } else {
            basePrice *= 1.2;
        }

        if (wingspan <= 10) {
            basePrice *= 1.2;
        } else if (wingspan <= 20) {
            basePrice *= 1.5;
        } else if (wingspan <= 30) {
            basePrice *= 1.8;
        } else {
            basePrice *= 2.0;
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return "Airplane{" +
               "isFragileCargo=" + isFragileCargo +
               ", wingspan=" + wingspan +
               '}';
    }
}
