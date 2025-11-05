package ro.ugal.aciee.vehicles;

import ro.ugal.aciee.vehicles.transport.Vehicle;
import ro.ugal.aciee.vehicles.transport.impl.*;
import ro.ugal.aciee.vehicles.transport.source.VehicleColor;
import ro.ugal.aciee.vehicles.transport.types.AeroVehicle;
import ro.ugal.aciee.vehicles.transport.types.RollingVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
          - Se va face un fisier de test care sa cuprinda cel putin cate 3 instante din cele 3 clase,
          folosind toti constructorii. Pentru fiecare instanta vor fi afisate datele membre.
         */

        System.out.println("----- Task 1 -------");

        AeroVehicle timJetplane = new Jetplane();
        timJetplane.setSpeed(1000);
        timJetplane.setColor(VehicleColor.WHITE);
        timJetplane.setFuelCapacity(50);
        timJetplane.setAccelerating(true);
        timJetplane.setBraking(false);
        timJetplane.setFuelLevel(300);
        timJetplane.setFuelConsumption(12);
        timJetplane.setYear(1945);
        timJetplane.setMileage(5000);

        RollingVehicle bohdanCar = new Car(VehicleColor.BLACK, 2005, 2000, 4, 40, 2, 40, 0, false, false, 4, false, 160, true);

        Vehicle artemPlane = new Airplane(timJetplane, 28.5, true);

        Vehicle sashaScooter = new RollingVehicle(bohdanCar);

        Vehicle iraYacht = new Yacht(timJetplane, 150, true, false);

        System.out.println(bohdanCar);
        System.out.println(artemPlane);
        System.out.println(sashaScooter);
        System.out.println(timJetplane);
        System.out.println(iraYacht);

        /*
        - Sa se creeze un vector cu cel putin 10 instante din fiecare clasa
          si sa se afiseze instantele pentru fiecare clasa.
         */

        System.out.println("----- Task 2 -------");

        Random random = new Random();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (random.nextInt(3)) {
                case 0 -> {
                    if (random.nextBoolean()) {
                        vehicles.add(new Jetplane());
                    } else {
                        vehicles.add(new Airplane(VehicleColor.BLACK, 2005, 2000, 4, 40, 2, 40, 0,
                                false, false, 200, 1500, 2, 14.5, false));
                    }
                }
                case 1 -> {
                    if (random.nextBoolean()) {
                        int speed = random.nextInt(100) + 1;
                        boolean accelerating = speed > 10;

                        vehicles.add(new Car(VehicleColor.BLACK, 2005, 2000, 4, 40, 2, 40, speed, accelerating, !accelerating, 4, false, 160, true));
                    } else {
                        vehicles.add(new Yacht(iraYacht, 100, false, true));
                    }
                }

                case 2 -> vehicles.add(new Scooter(bohdanCar, true, 200, 12));
            }
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        /*
        - Sa se afiseze instante ale celor 3 clase introduse in vectori in functie de doua conditii
          combinate aplicate asupra datelor membre, impuse in codul sursa.
         */

        System.out.println("----- Task 3 -------");

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof AeroVehicle && vehicle.getFuelLevel() > 20) {
                System.out.println(vehicle);
            }
        }

        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isBraking() && vehicle.getSpeed() > 10) {
                System.out.println(vehicle);
            }
        }

        /*
        - Sa se creeze interfeta grafica pentru aplicatie.
        Sa se seteze ascultatori pe componentele grafice si sa se testeze acesti ascultatori
        (sa afiseze ceva, sa seteze ceva, etc.).  Sa se citeasca din Gui (cel putin doua)
        conditii impuse pentru cel putin 3 date membre
        si sa se afiseze in Gui instantele care satisfac cerintele citite din Gui.
         */
        
    }

}