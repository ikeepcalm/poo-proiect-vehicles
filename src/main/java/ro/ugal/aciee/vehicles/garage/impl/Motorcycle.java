package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Motorcycle extends RollingVehicle {

    private double engineCc;
    private boolean sportBike;
    private int maxSpeedKmh;

    public Motorcycle() {
        super();
    }

    public Motorcycle(double engineCc, boolean sportBike, int maxSpeedKmh) {
        super();
        this.engineCc = engineCc;
        this.sportBike = sportBike;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Motorcycle(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, double engineCc, boolean sportBike) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.engineCc = engineCc;
        this.sportBike = sportBike;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Motorcycle(Motorcycle other) {
        super(other);
        this.engineCc = other.engineCc;
        this.sportBike = other.sportBike;
        this.maxSpeedKmh = other.maxSpeedKmh;
    }

    public double getEngineCc() {
        return engineCc;
    }

    public void setEngineCc(double engineCc) {
        this.engineCc = engineCc;
    }

    public boolean isSportBike() {
        return sportBike;
    }

    public void setSportBike(boolean sportBike) {
        this.sportBike = sportBike;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrise = 5.0;

        if (this.sportBike) {
            basePrise *= 1.5;
        }

        if (this.electric) {
            basePrise *= 0.9;
        }

        basePrise *= this.horsePower / 80.0;

        basePrise *= this.maxSpeedKmh / 120.0;

        return basePrise;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton sportModeButton = new JButton(sportBike ? "Disable Sport Mode" : "Enable Sport Mode");
        sportModeButton.addActionListener(e -> {
            sportBike = !sportBike;
            sportModeButton.setText(sportBike ? "Disable Sport Mode" : "Enable Sport Mode");
            JOptionPane.showMessageDialog(null,
                    "Sport mode is now " + (sportBike ? "ENABLED!" : "DISABLED!"),
                    "Sport Mode",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(sportModeButton);

        JButton speedBoostButton = new JButton("Increase Max Speed");
        speedBoostButton.addActionListener(e -> {
            if (maxSpeedKmh < 400) {
                maxSpeedKmh += 20;
                JOptionPane.showMessageDialog(null,
                        "Max speed increased to " + maxSpeedKmh + "km/h",
                        "Speed Update",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Maximum speed reached!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        actions.add(speedBoostButton);

        JButton infoButton = new JButton("Motorcycle Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Motorcycle Info:
                            Type: %s Motorcycle
                            Horsepower: %d HP
                            Max Speed: %d km/h
                            Engine: %.1f cc
                            Sport Mode: %s
                            Daily Price: $%.2f""",
                    electric ? "Electric" : "Gasoline",
                    horsePower,
                    maxSpeedKmh,
                    engineCc,
                    sportBike ? "ON" : "OFF",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Motorcycle Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "engineCc=" + engineCc +
                ", sportBike=" + sportBike +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }
}
