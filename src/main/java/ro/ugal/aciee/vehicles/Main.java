package ro.ugal.aciee.vehicles;

import ro.ugal.aciee.vehicles.service.VehicleFleet;
import ro.ugal.aciee.vehicles.garage.impl.Car;
import ro.ugal.aciee.vehicles.garage.impl.Truck;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;

public class Main {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   VEHICLE RENTAL SYSTEM   ");
        System.out.println("====================================\n");

        VehicleFleet fleet = new VehicleFleet();

        Car bohdanCar = new Car(2005, 300, VehicleColor.BLUE, 5, false, false, 100, 120, false, false);
        Truck bohdanTruck = new Truck(1998, 2000, VehicleColor.WHITE, 5, false, false, 200, 80, true);

        fleet.addRollingVehicle(bohdanCar);
        fleet.addRollingVehicle(bohdanTruck);

        System.out.println("\n==================================");
        System.out.println("          END OF PROJECT            ");
        System.out.println("====================================");
    }

}