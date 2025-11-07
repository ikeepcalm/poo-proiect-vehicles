package ro.ugal.aciee.vehicles;

import ro.ugal.aciee.vehicles.garage.impl.*;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;
import ro.ugal.aciee.vehicles.service.VehicleFleet;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;

public class Main {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   VEHICLE RENTAL SYSTEM   ");
        System.out.println("====================================\n");

        VehicleFleet fleet = new VehicleFleet();

        Car bohdanCar = new Car(2005, 300, VehicleColor.BLUE, 5, false, false, 100, 120, false, false);
        Truck bohdanTruck = new Truck(1998, 2000, VehicleColor.WHITE, 5, false, false, 200, 80, true);

        Atv artemsAtv = new Atv(2016,300,VehicleColor.BLACK,3,false,false,150,200,3,false);
        ElectricBike artemsBike = new ElectricBike(2024,2,VehicleColor.PINK,2,false,true,100,90,100," indura ");

        AeroVehicle timAirplane = new Airplane(1989, 3000, VehicleColor.WHITE, 10, false, 2500, 3000, 6, true, 10.5);
        AeroVehicle timJetsky = new Jetplane(2009, 1500, VehicleColor.BLACK, 5, true, 1000, 2000, 2, 9, true);

        fleet.addRollingVehicle(bohdanCar);
        fleet.addRollingVehicle(bohdanTruck);
        fleet.addRollingVehicle(artemsAtv);
        fleet.addRollingVehicle(artemsBike);
        fleet.addAerialVehicle(timAirplane);
        fleet.addAerialVehicle(timJetsky);



        System.out.println("\n==================================");
        System.out.println("          END OF PROJECT            ");
        System.out.println("====================================");
    }

}