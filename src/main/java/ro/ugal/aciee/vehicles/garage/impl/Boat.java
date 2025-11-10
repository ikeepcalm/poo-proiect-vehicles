package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Boat extends NavalVehicle {

    private boolean anchorDropped;
    private boolean isCabinLightsOn;

    public Boat() {
        super();
    }

    public Boat(boolean anchorDropped, boolean isCabinLightsOn) {
        super();
        this.anchorDropped = anchorDropped;
        this.isCabinLightsOn = isCabinLightsOn;
    }

    public Boat(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance,
                boolean electric, int horsePower, int maxSpeedKmh, boolean anchorDropped, boolean isCabinLightsOn) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.anchorDropped = anchorDropped;
        this.isCabinLightsOn = isCabinLightsOn;
    }

    public boolean isAnchorDropped() {
        return anchorDropped;
    }

    public void setAnchorDropped(boolean anchorDropped) {
        this.anchorDropped = anchorDropped;
    }

    public boolean isCabinLightsOn() {
        return isCabinLightsOn;
    }

    public void setCabinLightsOn(boolean cabinLightsOn) {
        isCabinLightsOn = cabinLightsOn;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 20.0;

        if (anchorDropped) {
            basePrice *= 1.1;
        }

        if (electric) {
            basePrice *= 0.85;
        }

        basePrice *= this.horsePower / 80.0;
        basePrice *= this.maxSpeedKmh / 50.0;

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton anchorButton = new JButton(anchorDropped ? "Raise Anchor" : "Drop Anchor");
        anchorButton.addActionListener(e -> {
            anchorDropped = !anchorDropped;
            anchorButton.setText(anchorDropped ? "Raise Anchor" : "Drop Anchor");
            JOptionPane.showMessageDialog(null,
                    "Anchor is now " + (anchorDropped ? "DROPPED" : "RAISED") + ".",
                    "Anchor Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(anchorButton);

        JButton lightsButton = new JButton(isCabinLightsOn ? "Turn Off Cabin Lights" : "Turn On Cabin Lights");
        lightsButton.addActionListener(e -> {
            isCabinLightsOn = !isCabinLightsOn;
            lightsButton.setText(isCabinLightsOn ? "Turn Off Cabin Lights" : "Turn On Cabin Lights");
            JOptionPane.showMessageDialog(null,
                    "Cabin lights are now " + (isCabinLightsOn ? "ON" : "OFF") + ".",
                    "Cabin Lights",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(lightsButton);

        JButton infoButton = new JButton("Boat Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    "Boat Details:\n" +
                            "Type: %s Boat\n" +
                            "Horsepower: %d HP\n" +
                            "Max Speed: %d km/h\n" +
                            "Anchor: %s\n" +
                            "Cabin Lights: %s\n" +
                            "Daily Price: $%.2f",
                    electric ? "Electric" : "Diesel",
                    horsePower,
                    maxSpeedKmh,
                    anchorDropped ? "Dropped" : "Raised",
                    isCabinLightsOn ? "ON" : "OFF",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null, info, "Boat Information", JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "anchorDropped=" + anchorDropped +
                ", isCabinLightsOn=" + isCabinLightsOn +
                '}';
    }
}
