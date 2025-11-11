package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Scooter extends RollingVehicle {

    private boolean electric;
    private double batteryKWh;
    private int maxSpeedKmh;

    public Scooter() {
        super();
    }

    public Scooter(boolean electric, double batteryKWh, int maxSpeedKmh) {
        super();
        this.electric = electric;
        this.batteryKWh = batteryKWh;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Scooter(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, double batteryKWh) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.electric = electric;
        this.batteryKWh = batteryKWh;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Scooter(Scooter other) {
        super(other);
        this.electric = other.electric;
        this.batteryKWh = other.batteryKWh;
        this.maxSpeedKmh = other.maxSpeedKmh;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public double getBatteryKWh() {
        return batteryKWh;
    }

    public void setBatteryKWh(double batteryKWh) {
        this.batteryKWh = batteryKWh;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 3.0;

        if (this.electric) {
            basePrice *= 0.85;
        }

        if (this.batteryKWh > 2.0) {
            basePrice *= 1.3;
        }

        basePrice *= this.horsePower / 50.0;

        basePrice *= this.maxSpeedKmh / 60.0;

        return basePrice;

    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton chargeButton = new JButton("Charge Battery");
        chargeButton.addActionListener(e -> {
            if (batteryKWh < 5.0) {
                batteryKWh += 0.5;
                JOptionPane.showMessageDialog(null,
                        String.format("Battery charged! Current level: %.1f kWh", batteryKWh),
                        "Battery Status",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Battery is fully charged!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        actions.add(chargeButton);

        JButton dischargeButton = new JButton("Use Battery");
        dischargeButton.addActionListener(e -> {
            if (batteryKWh > 0.5) {
                batteryKWh -= 0.5;
                JOptionPane.showMessageDialog(null,
                        String.format("Battery used! Current level: %.1f kWh", batteryKWh),
                        "Battery Status",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Battery too low!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        actions.add(dischargeButton);

        JButton infoButton = new JButton("Scooter Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Scooter Info:
                            Type: %s Scooter
                            Horsepower: %d HP
                            Max Speed: %d km/h
                            Battery: %.1f kWh
                            Daily Price: $%.2f""",
                    electric ? "Electric" : "Gasoline",
                    horsePower,
                    maxSpeedKmh,
                    batteryKWh,
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Scooter Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "electric=" + electric +
                ", batteryKWh=" + batteryKWh +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }
}
