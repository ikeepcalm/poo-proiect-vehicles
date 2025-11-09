package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Jetplane extends AeroVehicle {

    private double maxG;
    private boolean sharpNose;
    private double maxBoost;
    private double maxReduce;

    public Jetplane() {
        super();
    }

    public Jetplane(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, int maxHeight, int amountOfEngines, double maxG, boolean sharpNose) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, maxHeight, amountOfEngines);
        this.maxG = maxG;
        this.sharpNose = sharpNose;
        maxBoost = this.maxG + 2;
        maxReduce = this.maxG - 2;
    }

    public Jetplane(Jetplane other) {
        super(other);
        this.maxG = other.maxG;
        this.sharpNose = other.sharpNose;
        this.maxBoost = other.maxBoost;
        this.maxReduce = other.maxReduce;
    }

    public boolean getSharpNose() {
        return sharpNose;
    }

    public void setSharpNose(boolean sharpNose) {
        this.sharpNose = sharpNose;
    }

    public double getMaxG() {
        return maxG;
    }

    public void setMaxG(double maxG) {
        this.maxG = maxG;
        this.maxBoost = this.maxG + 2;
        this.maxReduce = this.maxG - 2;
    }

    @Override
    public double getDailyRentalPrice(){
        double basePrice = 1000.0;

        if (maxHeight > 2000) {
            basePrice += maxHeight * 0.2;
        }
        if (amountOfEngines > 4) {
            basePrice += amountOfEngines * 150;
        }

        if(maxPassengers > 10){
            basePrice += maxPassengers * 1.6;
        } else{
            basePrice += maxPassengers * 1.2;
        }

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions(){
        List<JButton> actions = new ArrayList<>();

        JButton noseButton = new JButton(sharpNose ? "Disable Sharp Nose" : "Enable Sharp Nose");
        noseButton.addActionListener(e -> {
            sharpNose = !sharpNose;
            noseButton.setText(sharpNose ? "Disable Sharp Nose" : "Enable Sharp Nose");
            JOptionPane.showMessageDialog(null,
                    "The jetplane's nose is now " + (sharpNose ? "SHARP" : "ROUNDED"),
                    "Nose Configuration Updated",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(noseButton);

        JButton boostGButton = new JButton("Boost G-Force");
        boostGButton.addActionListener(e -> {
            if (maxG < maxBoost) {
                maxG += 0.5;
                JOptionPane.showMessageDialog(
                        null,
                        String.format("Max G-force increased to %.2fg.", maxG),
                        "Performance Boosted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "G-force limit reached. Further boost not possible.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(boostGButton);

        JButton reduceGButton = new JButton("Reduce G-Force");
        reduceGButton.addActionListener(e -> {
            if (maxG > maxReduce) {
                maxG -= 0.5;
                JOptionPane.showMessageDialog(
                        null,
                        String.format("Max G-force reduced to %.2fg.", maxG),
                        "Performance Adjusted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "G-force already at minimum operational level.",
                        "Notice",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(reduceGButton);

        JButton infoButton = new JButton("Jetplane Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    "Jetplane Details:\n" +
                            "Max payload: %d kg\n" +
                            "Max height: %d m\n" +
                            "Engines: %d\n" +
                            "Sharp nose: %s\n" +
                            "Max G-force: %.2fg\n" +
                            "Daily Price: $%.2f",
                    maxPayload,
                    maxHeight,
                    amountOfEngines,
                    sharpNose ? "Yes" : "No",
                    maxG,
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Jetplane Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Jetplane{" +
               "maxG=" + maxG +
               ", sharpNose=" + sharpNose +
               '}';
    }
}
