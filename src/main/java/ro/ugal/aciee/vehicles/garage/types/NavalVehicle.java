package ro.ugal.aciee.vehicles.garage.types;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;

import java.util.UUID;

public abstract class NavalVehicle extends Vehicle {

    protected int maxPayload;

    protected boolean canOperateInStorm;

    public NavalVehicle() {
        super();
    }

    public NavalVehicle(NavalVehicle other) {
        super(other);

        this.maxPayload = other.maxPayload;
        this.canOperateInStorm = other.canOperateInStorm;
    }

    public NavalVehicle(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, boolean canOperateInStorm) {
        super(UUID.randomUUID(), year, mileage, color, maxPassengers, needsMaintenance);
        this.maxPayload = maxPayload;
        this.canOperateInStorm = canOperateInStorm;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public boolean getIsCanOperateInStorm() {
        return canOperateInStorm;
    }

    public void setCanOperateInStorm(boolean canOperateInStorm) {
        this.canOperateInStorm = canOperateInStorm;
    }

    @Override
    public String toString() {
        return "NavalVehicle{" +
                "maxPayload=" + maxPayload +
                ", canOperateInStorm=" + canOperateInStorm +
                '}';
    }


}
