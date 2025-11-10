package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.AeroVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airplane extends AeroVehicle {

    private boolean isFragileCargo;
    private double wingspan;
    private boolean openWingspan = false;

    public Airplane() {
        super();
    }

    public Airplane(boolean random) {
        this();

        if (!random) {
            return;
        }

        Random rand = new Random();

        this.year = rand.nextInt(240) + 1800;
        this.mileage = rand.nextInt(3000) + 1500;
        int index = rand.nextInt(VehicleColor.values().length);
        this.color = VehicleColor.values()[index];
        this.maxPassengers = rand.nextInt(100) + 60;
        this.needsMaintenance = rand.nextBoolean();
        this.maxPayload = rand.nextInt(1000) + 2000;
        this.maxHeight = rand.nextInt(3000) + 6000;
        boolean foundEvenEngineCount = true;
        while (foundEvenEngineCount) {
            int engineCountCandidate = rand.nextInt(6) + 2;
            if (engineCountCandidate % 2 == 0) {
                this.amountOfEngines = engineCountCandidate;
                foundEvenEngineCount = false;
            }
        }
        this.isFragileCargo = rand.nextBoolean();
        this.wingspan = rand.nextDouble(20.0) + 10.0;
        this.openWingspan = rand.nextBoolean();
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
        this.openWingspan = other.openWingspan;
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
                    """
                            Airplane Details:
                            Max payload: %d kg
                            Max height: %d m
                            Engines: %d
                            Fragile Gargo: %s
                            Wingspan: %.2fm
                            Daily Price: $%.2f""",
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
