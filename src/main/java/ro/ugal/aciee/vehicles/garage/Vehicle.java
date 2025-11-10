package ro.ugal.aciee.vehicles.garage;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Vehicle implements Rentable, Serializable {

    protected UUID id;
    protected int year;
    protected int mileage;
    protected VehicleColor color;
    protected int maxPassengers;
    protected boolean isRented;
    protected String currentRenterName;
    protected boolean needsMaintenance;

    public Vehicle() {
        this.id = UUID.randomUUID();
        this.isRented = false;
        this.needsMaintenance = false;
        this.maxPassengers = 4;
        this.color = VehicleColor.WHITE;
        this.year = 2018;
        this.mileage = 0;
        currentRenterName = null;
    }

    public Vehicle(UUID id, int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance) {
        this.id = id;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.maxPassengers = maxPassengers;
        this.needsMaintenance = needsMaintenance;
    }

    public Vehicle(Vehicle other) {
        this.id = other.id;
        this.year = other.year;
        this.mileage = other.mileage;
        this.color = other.color;
        this.maxPassengers = other.maxPassengers;
        this.isRented = other.isRented;
        this.currentRenterName = other.currentRenterName;
        this.needsMaintenance = other.needsMaintenance;
    }

    @Override
    public boolean rent(String customerName) {
        boolean canRent = !isRented && !isNeedsMaintenance();

        if (canRent) {
            this.currentRenterName = customerName;
            this.isRented = true;
        }

        return isRented;
    }

    @Override
    public boolean returnVehicle() {
        boolean canReturn = isRented;

        if (canReturn) {
            this.currentRenterName = null;
            this.isRented = false;
        }

        return canReturn;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getDailyRentalPrice();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public VehicleColor getColor() {
        return color;
    }

    public void setColor(VehicleColor color) {
        this.color = color;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getCurrentRenterName() {
        return currentRenterName;
    }

    public void setCurrentRenterName(String currentRenterName) {
        this.currentRenterName = currentRenterName;
    }

    public boolean isNeedsMaintenance() {
        return needsMaintenance;
    }

    public void setNeedsMaintenance(boolean needsMaintenance) {
        this.needsMaintenance = needsMaintenance;
    }

    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton infoButton = new JButton("Vehicle Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    "Vehicle Information:\n\n" +
                    "ID: %s\n" +
                    "Year: %d\n" +
                    "Mileage: %d km\n" +
                    "Color: %s\n" +
                    "Max Passengers: %d\n" +
                    "Status: %s\n" +
                    "Needs Maintenance: %s\n" +
                    "Daily Rental Price: $%.2f",
                    id.toString().substring(0, 8) + "...",
                    year,
                    mileage,
                    color,
                    maxPassengers,
                    isRented ? "Rented to " + currentRenterName : "Available",
                    needsMaintenance ? "Yes" : "No",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Vehicle Details",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
               "id=" + id +
               ", year=" + year +
               ", mileage=" + mileage +
               ", color=" + color +
               ", maxPassengers=" + maxPassengers +
               ", isRented=" + isRented +
               ", currentRenterName='" + currentRenterName + '\'' +
               ", needsMaintenance=" + needsMaintenance +
               '}';
    }
}
