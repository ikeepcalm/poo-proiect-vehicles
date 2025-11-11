package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Atv extends RollingVehicle {

    private int size;
    private boolean spareWheel;

    public Atv() {
        super();
    }


    public Atv(int size, boolean spareWheel) {
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public Atv(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, int size, boolean spareWheel) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public Atv(RollingVehicle other, int size, boolean spareWheel) {
        super(other);
        this.size = size;
        this.spareWheel = spareWheel;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(boolean spareWheel) {
        this.spareWheel = spareWheel;
    }


    @Override
    public double getDailyRentalPrice() {
        double defaultPrice = 100;
        if (this.spareWheel == true) {
            defaultPrice *= 2;
        }
        if (this.size > 4) {
            defaultPrice += 100;

        }
        return defaultPrice;
    }

    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton wheelButton = new JButton(spareWheel ? " Remove spare wheel" : "Add spare wheel");
        wheelButton.addActionListener(e -> {
            spareWheel = !spareWheel;
            wheelButton.setText(spareWheel ? " Remove spare wheel " : " Add spare wheel ");
            JOptionPane.showMessageDialog(null,
                    " Spare wheel has been " + (spareWheel ? "Added" : "Removed"),
                    " Wheel Updated",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(wheelButton);

        JButton sizeButton = new JButton(" Increase size ");
        sizeButton.addActionListener(e -> {
            if (size < 10) {
                size += 1;
                JOptionPane.showMessageDialog(
                        null,
                        String.format(" Size have been increased to %s", size),
                        " Increased ",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        " Max size ",
                        " Increased ",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(sizeButton);

        JButton reducesizeButton = new JButton(" Decrease size ");
        reducesizeButton.addActionListener(e -> {
            if (size > 1) {
                size -= 1;
                JOptionPane.showMessageDialog(
                        null,
                        String.format(" Size has been decreasesd to %s", size),
                        " Decrased ",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        " Minimal size ",
                        " Warning ",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(reducesizeButton);

        JButton infoButton = new JButton("Atv info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Atv Info:
                            Type: %s Atv
                            Horsepower: %d HP
                            Max Speed: %d km/h
                            Size: %d
                            Spare wheel: %s
                            Daily Price: $%.2f""",
                    electric ? "Electric" : "Gasoline",
                    horsePower,
                    maxSpeedKmh,
                    size,
                    spareWheel ? "YES" : "NO",
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

    @Override
    public String toString() {
        return "Atv{" +
                "size=" + size +
                ", spareWheel=" + spareWheel +
                '}';
    }
}
















