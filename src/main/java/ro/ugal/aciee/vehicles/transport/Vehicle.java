package ro.ugal.aciee.vehicles.transport;

import ro.ugal.aciee.vehicles.transport.source.VehicleColor;

public abstract class Vehicle {

    private VehicleColor color;

    private int year;
    private int mileage;

    private int capacity;

    private int fuelCapacity;
    private int fuelConsumption;
    private int fuelLevel;

    private double speed;

    private boolean accelerating;
    private boolean braking;

    public abstract void accelerate();

    public abstract void brake();

    public Vehicle() {

    }

    public Vehicle(Vehicle other) {
        this.color = other.color;
        this.year = other.year;
        this.mileage = other.mileage;
        this.capacity = other.capacity;
        this.fuelCapacity = other.fuelCapacity;
        this.fuelConsumption = other.fuelConsumption;
        this.fuelLevel = other.fuelLevel;
        this.speed = other.speed;
        this.accelerating = other.accelerating;
        this.braking = other.braking;
    }

    public Vehicle(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking) {
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.speed = speed;
        this.accelerating = accelerating;
        this.braking = braking;
    }

    public VehicleColor getColor() {
        return color;
    }

    public void setColor(VehicleColor color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isAccelerating() {
        return accelerating;
    }

    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    public boolean isBraking() {
        return braking;
    }

    public void setBraking(boolean braking) {
        this.braking = braking;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
               "color=" + color +
               ", year=" + year +
               ", mileage=" + mileage +
               ", capacity=" + capacity +
               ", fuelCapacity=" + fuelCapacity +
               ", fuelConsumption=" + fuelConsumption +
               ", fuelLevel=" + fuelLevel +
               ", speed=" + speed +
               ", accelerating=" + accelerating +
               ", braking=" + braking +
               '}';
    }

}
