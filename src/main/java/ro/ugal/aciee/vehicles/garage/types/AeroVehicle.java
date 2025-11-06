package ro.ugal.aciee.vehicles.garage.types;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;

import java.util.UUID;

public abstract class AeroVehicle extends Vehicle {

    protected int maxPayload;

    protected int maxHeight;

    protected int amountOfEngines;

    public AeroVehicle() {
        super();
    }


    public AeroVehicle(AeroVehicle other) {
        super(other);

        this.maxPayload = other.maxPayload;
        this.maxHeight = other.maxHeight;
        this.amountOfEngines = other.amountOfEngines;
    }

    public AeroVehicle(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, int maxHeight, int amountOfEngines) {
        super(UUID.randomUUID(), year, mileage, color, maxPassengers, needsMaintenance);
        this.maxPayload = maxPayload;
        this.maxHeight = maxHeight;
        this.amountOfEngines = amountOfEngines;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getAmountOfEngines() {
        return amountOfEngines;
    }

    public void setAmountOfEngines(int amountOfEngines) {
        this.amountOfEngines = amountOfEngines;
    }

    @Override
    public String toString() {
        return "AeroVehicle{" +
               "maxPayload=" + maxPayload +
               ", maxHeight=" + maxHeight +
               ", amountOfEngines=" + amountOfEngines +
               '}';
    }
}
