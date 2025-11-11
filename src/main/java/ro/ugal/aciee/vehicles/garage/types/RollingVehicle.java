package ro.ugal.aciee.vehicles.garage.types;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;

import java.util.UUID;

public abstract class RollingVehicle extends Vehicle {

    protected boolean electric;

    protected int horsePower;

    protected int maxSpeedKmh;

    public RollingVehicle() {
        super();
    }

    public RollingVehicle(RollingVehicle other) {
        super(other);

        this.electric = other.isElectric();
        this.horsePower = other.getHorsePower();
        this.maxSpeedKmh = other.getMaxSpeedKmh();
    }

    public RollingVehicle(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh) {
        super(UUID.randomUUID(), year, mileage, color, maxPassengers, needsMaintenance);
        this.electric = electric;
        this.horsePower = horsePower;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public RollingVehicle(boolean electric, int horsePower, int maxSpeedKmh) {
        super();
        this.electric = electric;
        this.horsePower = horsePower;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public String toString() {
        return "RollingVehicle{" +
                "electric=" + electric +
                ", horsePower=" + horsePower +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }
}
