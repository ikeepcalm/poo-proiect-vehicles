package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Airplane extends AeroVehicle {

    private boolean isFragileCargo;
    private double wingspan;
    private boolean openWingspan = false;

    public Airplane() {
        super();
    }

    public Airplane(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, int maxHeight, int amountOfEngines, boolean isFragileCargo, double wingspan) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, maxHeight, amountOfEngines);
        this.isFragileCargo = isFragileCargo;
        this.wingspan = wingspan;
    }

    public Airplane(Airplane other) {
        super(other);
        this.isFragileCargo = other.isFragileCargo;
        this.wingspan = other.wingspan;
    }

    public boolean getIsFragileCargo() {
        return isFragileCargo;
    }

    public void setIsFragileCargo(boolean fragileCargo) {
        isFragileCargo = fragileCargo;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 1500.0;

        if (isFragileCargo) {
            basePrice *= 1.8;
        } else {
            basePrice *= 1.2;
        }

        if (wingspan <= 10) {
            basePrice *= 1.2;
        } else if (wingspan <= 20) {
            basePrice *= 1.5;
        } else if (wingspan <= 30) {
            basePrice *= 1.8;
        } else {
            basePrice *= 2.0;
        }

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton fragileButton = new JButton(isFragileCargo ? "Disable Fragile Cargo Mode" : "Enable Fragile Cargo Mode");
        fragileButton.addActionListener(e -> {
            isFragileCargo = !isFragileCargo;
            fragileButton.setText(isFragileCargo ? "Disable Fragile Cargo Mode" : "Enable Fragile Cargo Mode");
            JOptionPane.showMessageDialog(
                    null,
                    "Fragile cargo mode is now " + (isFragileCargo ? "ENABLED" : "DISABLED"),
                    "Fragile Cargo Status Updated",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        actions.add(fragileButton);

        JButton wingspanButton = new JButton(openWingspan ? "Close wingspan" : "Open wingspan");
        wingspanButton.addActionListener(e -> {
            openWingspan = !openWingspan;
            if (openWingspan) {
                wingspan += 1.5;
            } else {
                wingspan -= 1.5;
            }
            wingspanButton.setText(openWingspan ? "Close wingspan" : "Open wingspan");
            JOptionPane.showMessageDialog(
                    null,
                    "Wingspan is now " + (openWingspan ? "OPEN" : "CLOSED"),
                    "Wingspan Status Updated",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        actions.add(wingspanButton);

        JButton infoButton = new JButton("Airplane Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    "Airplane Details:\n" +
                    "Max payload: %d kg\n" +
                    "Max height: %d m\n" +
                    "Engines: %d\n" +
                    "Fragile Gargo: %s\n" +
                    "Wingspan: %.2fm\n" +
                    "Daily Price: $%.2f",
                    maxPayload,
                    maxHeight,
                    amountOfEngines,
                    isFragileCargo ? "Yes" : "No",
                    wingspan,
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Airplane Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Airplane{" +
               "isFragileCargo=" + isFragileCargo +
               ", wingspan=" + wingspan +
               '}';
    }
}
