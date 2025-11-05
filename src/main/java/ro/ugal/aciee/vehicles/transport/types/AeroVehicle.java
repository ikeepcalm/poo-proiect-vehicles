package ro.ugal.aciee.vehicles.transport.types;

import ro.ugal.aciee.vehicles.transport.Vehicle;
import ro.ugal.aciee.vehicles.transport.source.VehicleColor;

public class AeroVehicle extends Vehicle {

    private int loadCapacity;

    private int maxHeight;

    private int amountOfEngines;

    @Override
    public void accelerate() {
        System.out.println("Accelerating...");
        super.setFuelLevel(super.getFuelLevel() - super.getFuelConsumption());
    }

    @Override
    public void brake() {
        System.out.println("Braking...");
        super.setSpeed(super.getSpeed() * 0.9);
    }

    public AeroVehicle() {
        super();
    }

    public AeroVehicle(AeroVehicle other) {
        super(other);
        this.loadCapacity = other.loadCapacity;
        this.maxHeight = other.maxHeight;
        this.amountOfEngines = other.amountOfEngines;
    }

    public AeroVehicle(Vehicle other, int loadCapacity, int maxHeight, int amountOfEngines) {
        super(other);
        this.loadCapacity = loadCapacity;
        this.maxHeight = maxHeight;
        this.amountOfEngines = amountOfEngines;
    }

    public AeroVehicle(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int loadCapacity, int maxHeight, int amountOfEngines) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
        this.loadCapacity = loadCapacity;
        this.maxHeight = maxHeight;
        this.amountOfEngines = amountOfEngines;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
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
               "loadCapacity=" + loadCapacity +
               ", maxHeight=" + maxHeight +
               ", amountOfEngines=" + amountOfEngines +
               '}';
    }
}
