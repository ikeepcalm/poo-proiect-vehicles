package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ElectricBike extends RollingVehicle {

    private int range;
    private String address;

    public ElectricBike() {
        super();
    }

    public ElectricBike(int range, String address) {
        this.range = range;
        this.address = address;
    }

    public ElectricBike(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, int range, String address) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.range = range;
        this.address = address;

    }

    public ElectricBike(RollingVehicle other, int range, String address) {
        super(other);
        this.range = range;
        this.address = address;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public double getDailyRentalPrice() {
        double DefaulPrice = 20;
        if (this.range > 500) {
            DefaulPrice *= 0.5;
        }
        if (this.color == VehicleColor.PINK) {
            DefaulPrice *= 10;
        }
        return DefaulPrice;

    }

    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton rangeButton = new JButton(" increase range ");
        rangeButton.addActionListener(e -> {
            if (range < 2000) {
                range += 100;
                JOptionPane.showMessageDialog(
                        null,
                        String.format(" Range has been increasesd to %s", range),
                        " increase range ",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        " Max range ",
                        " Warning ",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(rangeButton);

        JButton reducerangeButton = new JButton(" Reduce range ");
        reducerangeButton.addActionListener(e -> {
            if (range > 100) {
                range -= 100;
                JOptionPane.showMessageDialog(
                        null,
                        String.format(" Range has been reduced to %s", range),
                        " Reduce range ",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        " Minimal range ",
                        " Warning ",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(reducerangeButton);


        actions.add(reducerangeButton);
        JButton infoButton = new JButton("Bike info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Bike Info:
                            Type: %s Bike
                            Horsepower: %d HP
                            Max Speed: %d km/h
                            Range: %d
                            Daily Price: $%.2f""",
                    electric ? "Electric" : "Gasoline",
                    horsePower,
                    maxSpeedKmh,
                    range,
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Bike Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "ElectricBike{" +
                "range=" + range +
                ", address='" + address + '\'' +
                '}';
    }
}








