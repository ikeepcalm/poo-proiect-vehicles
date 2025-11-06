package ro.ugal.aciee.vehicles.service;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleFleet {

    private final List<RollingVehicle> rollingVehicles;
    private final List<AeroVehicle> aerialVehicles;
    private final List<NavalVehicle> navalVehicles;

    public VehicleFleet() {
        this.rollingVehicles = new ArrayList<>();
        this.aerialVehicles = new ArrayList<>();
        this.navalVehicles = new ArrayList<>();
    }

    public void addRollingVehicle(RollingVehicle rollingVehicle) {
        this.rollingVehicles.add(rollingVehicle);
    }

    public void addRollingVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (vehicle instanceof RollingVehicle rollingVehicle) {
            this.rollingVehicles.add(rollingVehicle);
        } else {
            throw new IllegalArgumentException("The selected vehicle is not rolling");
        }
    }

    public void addAerialVehicle(AeroVehicle aerialVehicle) {
        this.aerialVehicles.add(aerialVehicle);
    }

    public void addAerialVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (vehicle instanceof AeroVehicle aerialVehicle) {
            this.aerialVehicles.add(aerialVehicle);
        } else {
            throw new IllegalArgumentException("The selected vehicle is not aerial");
        }
    }

    public void addNavalVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (vehicle instanceof NavalVehicle navalVehicle) {
            this.navalVehicles.add(navalVehicle);
        } else {
            throw new IllegalArgumentException(" The selected vehicle is not naval ");
        }
    }

    public void addNavalVehicle(NavalVehicle navalVehicle) {
        this.navalVehicles.add(navalVehicle);
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        for (RollingVehicle rollingVehicle : rollingVehicles) {
            vehicles.add(rollingVehicle);
        }

        for (AeroVehicle aerialVehicle : aerialVehicles) {
            vehicles.add(aerialVehicle);
        }

        for (NavalVehicle navalVehicle : navalVehicles) {
            vehicles.add(navalVehicle);
        }

        return vehicles;
    }

    public int getTotalVehicleCount() {
        return rollingVehicles.size() + aerialVehicles.size() + navalVehicles.size();
    }

    public int getAvailableVehicleCount() {
        List<Vehicle> allVehicles = getAllVehicles();

        int availableVehicles = 0;

        for (Vehicle vehicle : allVehicles) {
            if (!vehicle.isRented() && !vehicle.isNeedsMaintenance()) {
                ++availableVehicles;
            }
        }

        return availableVehicles;
    }

    public List<Vehicle> getVehiclesByColorAndYear(VehicleColor color, int year) {
        List<Vehicle> allVehicles = getAllVehicles();
        List<Vehicle> vehiclesByColorAndYear = new ArrayList<>();

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getColor() == color && vehicle.getYear() == year) {
                vehiclesByColorAndYear.add(vehicle);
            }
        }

        return vehiclesByColorAndYear;
    }

    public List<Vehicle> getVehiclesByMaxPassengersAndDailyPrice(int maxPassengers, double dailyPrice) {
        List<Vehicle> allVehicles = getAllVehicles();
        List<Vehicle> vehiclesByMaxPassengersAndDailyPrice = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getMaxPassengers() > maxPassengers && vehicle.getDailyRentalPrice() < dailyPrice) {
                vehiclesByMaxPassengersAndDailyPrice.add(vehicle);
            }
        }

        return vehiclesByMaxPassengersAndDailyPrice;
    }

    public List<Vehicle> getVehiclesByDaysAndBudget(int days, double budget) {
        List<Vehicle> allVehicles = getAllVehicles();
        List<Vehicle> vehiclesByDaysAndBudget = new ArrayList<>();

        for (Vehicle vehicle : allVehicles) {
            double price = vehicle.calculateRentalCost(days);

            if (price < budget) {
                vehiclesByDaysAndBudget.add(vehicle);
            }
        }

        return vehiclesByDaysAndBudget;
    }

    public List<RollingVehicle> getRollingVehicles() {
        return rollingVehicles;
    }

    public List<AeroVehicle> getAerialVehicles() {
        return aerialVehicles;
    }

    public List<NavalVehicle> getNavalVehicles() {
        return navalVehicles;
    }
}
