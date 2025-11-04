package ro.ugal.aciee.vehicles.transport.types;

import ro.ugal.aciee.vehicles.transport.Vehicle;
import ro.ugal.aciee.vehicles.transport.source.VehicleColor;

public class RollingVehicle extends Vehicle {

    private int numberOfWheels;

    private boolean isElectric;

    private int horsePower;

    public RollingVehicle() {
        super();
    }

    public RollingVehicle(RollingVehicle other) {
        super(other);
        this.numberOfWheels = other.numberOfWheels;
        this.isElectric = other.isElectric;
        this.horsePower = other.horsePower;
    }

    public RollingVehicle(Vehicle other, int numberOfWheels, int horsePower) {
        super(other);
        this.numberOfWheels = numberOfWheels;
        this.isElectric = false;
        this.horsePower = horsePower;
    }

    public RollingVehicle(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int numberOfWheels, boolean isElectric, int horsePower) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
        this.numberOfWheels = numberOfWheels;
        this.isElectric = isElectric;
        this.horsePower = horsePower;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "RollingVehicle{" +
               "numberOfWheels=" + numberOfWheels +
               ", isElectric=" + isElectric +
               ", horsePower=" + horsePower +
               '}';
    }
}
