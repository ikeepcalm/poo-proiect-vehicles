package ro.ugal.aciee.vehicles.transport.types;

import ro.ugal.aciee.vehicles.transport.Vehicle;
import ro.ugal.aciee.vehicles.transport.source.VehicleColor;

public class AquaVehicle extends Vehicle {

    public AquaVehicle() {
        super();
    }

    public AquaVehicle(VehicleColor color, int year, int mileage, int capacity, int fuelCapacity, int fuelConsumption, int fuelLevel, double speed, boolean accelerating, boolean braking) {
        super(color, year, mileage, capacity, fuelCapacity, fuelConsumption, fuelLevel, speed, accelerating, braking);
    }

    public AquaVehicle(AquaVehicle other) {
        super(other);
    }


}
