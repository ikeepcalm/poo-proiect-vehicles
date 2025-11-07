package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;


public class Jetplane extends AeroVehicle {

    private double maxG;
    private boolean sharpNose;

    public Jetplane() {
        super();
    }

    public Jetplane(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, int maxHeight, int amountOfEngines, double maxG, boolean sharpNose) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, maxHeight, amountOfEngines);
        this.maxG = maxG;
        this.sharpNose = sharpNose;
    }

    public Jetplane(Jetplane other) {
        super(other);
        this.maxG = other.maxG;
        this.sharpNose = other.sharpNose;
    }

    public boolean getSharpNose() {
        return sharpNose;
    }

    public void setSharpNose(boolean sharpNose) {
        this.sharpNose = sharpNose;
    }

    public double getMaxG() {
        return maxG;
    }

    public void setMaxG(double maxG) {
        this.maxG = maxG;
    }

    @Override
    public double getDailyRentalPrice(){
        double basePrice = 1000.0;

        if (maxHeight > 2000) {
            basePrice += maxHeight * 0.2;
        }
        if (amountOfEngines > 4) {
            basePrice += amountOfEngines * 150;
        }

        if(maxPassengers > 10){
            basePrice += maxPassengers * 1.6;
        } else{
            basePrice += maxPassengers * 1.2;
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return "Jetplane{" +
               "maxJ=" + maxG +
               ", isNoseSharp=" + sharpNose +
               '}';
    }
}
