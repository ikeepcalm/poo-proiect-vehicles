package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sailboat extends NavalVehicle {

    private boolean sailsRaised;
    private boolean rudderLocked;

    public Sailboat() {
        super();
    }

    public Sailboat(boolean sailsRaised, boolean rudderLocked) {
        super();
        this.sailsRaised = sailsRaised;
        this.rudderLocked = rudderLocked;
    }

    public Sailboat(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance,
                    boolean electric, int horsePower, int maxSpeedKmh, boolean sailsRaised, boolean rudderLocked) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.sailsRaised = sailsRaised;
        this.rudderLocked = rudderLocked;
    }

    public boolean isSailsRaised() {
        return sailsRaised;
    }

    public void setSailsRaised(boolean sailsRaised) {
        this.sailsRaised = sailsRaised;
    }

    public boolean isRudderLocked() {
        return rudderLocked;
    }

    public void setRudderLocked(boolean rudderLocked) {
        this.rudderLocked = rudderLocked;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 25.0;

        if (sailsRaised) {
            basePrice *= 1.2;
        }

        if (electric) {
            basePrice *= 0.9;
        }

        basePrice *= this.horsePower / 70.0;
        basePrice *= this.maxSpeedKmh / 60.0;

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton sailsButton = new JButton(sailsRaised ? "Lower Sails" : "Raise Sails");
        sailsButton.addActionListener(e -> {
            sailsRaised = !sailsRaised;
            sailsButton.setText(sailsRaised ? "Lower Sails" : "Raise Sails");
            JOptionPane.showMessageDialog(null,
                    "Sails are now " + (sailsRaised ? "RAISED" : "LOWERED") + ".",
                    "Sails Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(sailsButton);

        JButton rudderButton = new JButton(rudderLocked ? "Unlock Rudder" : "Lock Rudder");
        rudderButton.addActionListener(e -> {
            rudderLocked = !rudderLocked;
            rudderButton.setText(rudderLocked ? "Unlock Rudder" : "Lock Rudder");
            JOptionPane.showMessageDialog(null,
                    "Rudder is now " + (rudderLocked ? "LOCKED" : "UNLOCKED") + ".",
                    "Rudder Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(rudderButton);

        JButton infoButton = new JButton("Sailboat Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    "Sailboat Details:\n" +
                            "Type: %s Sailboat\n" +
                            "Horsepower: %d HP\n" +
                            "Max Speed: %d km/h\n" +
                            "Sails: %s\n" +
                            "Rudder: %s\n" +
                            "Daily Price: $%.2f",
                    electric ? "Electric" : "Wind-assisted",
                    horsePower,
                    maxSpeedKmh,
                    sailsRaised ? "Raised" : "Lowered",
                    rudderLocked ? "Locked" : "Unlocked",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null, info, "Sailboat Information", JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Sailboat{" +
                "sailsRaised=" + sailsRaised +
                ", rudderLocked=" + rudderLocked +
                '}';
    }
}
