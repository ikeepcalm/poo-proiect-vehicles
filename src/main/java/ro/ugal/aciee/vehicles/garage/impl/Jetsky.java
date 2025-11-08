package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

public class Jetsky extends NavalVehicle {

    private int amountOfPilots;
    private double loudness;

    public Jetsky() {
        super();
    }

    public Jetsky(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, boolean canOperateInStorm, int amountOfPilots, double loudness) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, canOperateInStorm);
        this.amountOfPilots = amountOfPilots;
        this.loudness = loudness;
    }

    public Jetsky(Jetsky other) {
        super(other);
        this.amountOfPilots = other.amountOfPilots;
        this.loudness = other.loudness;
    }

    public int getAmountOfPilots() {
        return amountOfPilots;
    }

    public void setAmountOfPilots(int amountOfPilots) {
        this.amountOfPilots = amountOfPilots;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    @Override
    public double getDailyRentalPrice(){
        double basePrice = 200.0;

        if(amountOfPilots > 1){
            basePrice *= amountOfPilots * 1.7;
        } else{
            basePrice *= amountOfPilots * 1.2;
        }

        if(maxPayload < 120){
            basePrice *= 1.2;
        } else{
            basePrice *= 1.6;
        }

        return basePrice;
    }


    @Override
    public String toString() {
        return "Jetsky{" +
               "amountOfPilots=" + amountOfPilots +
               ", loudnessl=" + loudness +
               '}';
    }
}

