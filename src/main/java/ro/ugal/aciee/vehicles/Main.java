package ro.ugal.aciee.vehicles;

import ro.ugal.aciee.vehicles.transport.Vehicle;
import ro.ugal.aciee.vehicles.transport.types.AeroVehicle;
import ro.ugal.aciee.vehicles.transport.types.RollingVehicle;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new RollingVehicle();
        System.out.println(car);

        Vehicle plane = new AeroVehicle(car, 200, 5000, 4);
        System.out.println(plane);
    }

}