package ro.ugal.aciee.vehicles.transport.types;

import ro.ugal.aciee.vehicles.transport.Vehicle;
import ro.ugal.aciee.vehicles.transport.source.VehicleColor;

public class NavalVehicle extends Vehicle {

    private int buoyancyInKg;

    @Override
    public void accelerate() {
        System.out.println("Accelerating naval vehicle...");
        super.setSpeed(super.getSpeed() * 1.1);
    }

    @Override
    public void brake() {
        System.out.println("Braking naval vehicle...");
        this.buoyancyInKg -= 2;
    }

    public NavalVehicle() {
        super();
    }

    public NavalVehicle(Vehicle other, int buoyancyInKg) {
        super(other);
        this.buoyancyInKg = buoyancyInKg;
    }

    public NavalVehicle(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking, int buoyancyInKg) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
        this.buoyancyInKg = buoyancyInKg;
    }

    public int getBuoyancyInKg() {
        return buoyancyInKg;
    }

    public void setBuoyancyInKg(int buoyancyInKg) {
        this.buoyancyInKg = buoyancyInKg;
    }
}
