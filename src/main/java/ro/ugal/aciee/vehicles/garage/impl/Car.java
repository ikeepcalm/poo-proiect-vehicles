package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Car extends RollingVehicle {

    private boolean isRadioOn;

    private boolean isStorageFull;

    public Car() {
        super();
    }

    public Car(boolean isRadioOn, boolean isStorageFull) {
        super();
        this.isRadioOn = isRadioOn;
        this.isStorageFull = isStorageFull;
    }

    public Car(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, boolean isRadioOn, boolean isStorageFull) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.isRadioOn = isRadioOn;
        this.isStorageFull = isStorageFull;
    }

    public boolean isRadioOn() {
        return isRadioOn;
    }

    public void setRadioOn(boolean isRadioOn) {
        this.isRadioOn = isRadioOn;
    }

    public boolean isStorageFull() {
        return isStorageFull;
    }

    public void setStorageFull(boolean isStorageFull) {
        this.isStorageFull = isStorageFull;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 10.0;

        if (this.isStorageFull) {
            basePrice *= 2;
        }

        if (this.electric) {
            basePrice *= 0.8;
        }

        basePrice *= this.horsePower / 100.0;

        basePrice *= this.maxSpeedKmh / 100.0 * 2.0;

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton radioButton = new JButton(isRadioOn ? "Turn Radio Off" : "Turn Radio On");
        radioButton.addActionListener(e -> {
            isRadioOn = !isRadioOn;
            radioButton.setText(isRadioOn ? "Turn Radio Off" : "Turn Radio On");
            JOptionPane.showMessageDialog(null,
                    "Radio is now " + (isRadioOn ? "ON" : "OFF") + "!",
                    "Radio Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(radioButton);

        JButton storageButton = new JButton(isStorageFull ? "Empty Storage" : "Fill Storage");
        storageButton.addActionListener(e -> {
            isStorageFull = !isStorageFull;
            storageButton.setText(isStorageFull ? "Empty Storage" : "Fill Storage");
            String message = isStorageFull ?
                    "Storage is now FULL! Rental price has doubled." :
                    "Storage is now EMPTY. Rental price returned to normal.";
            JOptionPane.showMessageDialog(null,
                    message,
                    "Storage Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(storageButton);

        JButton infoButton = new JButton("Car Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    "Car Details:\n" +
                    "Type: %s Car\n" +
                    "Horsepower: %d HP\n" +
                    "Max Speed: %d km/h\n" +
                    "Radio: %s\n" +
                    "Storage: %s\n" +
                    "Daily Price: $%.2f",
                    electric ? "Electric" : "Gasoline",
                    horsePower,
                    maxSpeedKmh,
                    isRadioOn ? "ON" : "OFF",
                    isStorageFull ? "FULL" : "EMPTY",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Car Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

}
