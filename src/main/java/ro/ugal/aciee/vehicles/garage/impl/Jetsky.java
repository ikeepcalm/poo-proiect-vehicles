package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jetsky extends NavalVehicle {

    private int amountOfPilots;
    private double loudness;

    public Jetsky() {
        super();
    }

    public Jetsky(boolean random){
        this();

        if(!random){
            return;
        }

        Random rand = new Random();

        this.year = rand.nextInt(240) + 1800;
        this.mileage = rand.nextInt(1500) + 2500;
        int index = rand.nextInt(VehicleColor.values().length);
        this.color = VehicleColor.values()[index];
        this.maxPassengers = rand.nextInt(10) + 4;
        this.needsMaintenance = rand.nextBoolean();
        this.maxPayload =  rand.nextInt(2000) + 2000;
        this.canOperateInStorm = rand.nextBoolean();
        this.amountOfPilots = rand.nextInt(3) + 1;
        this.loudness = rand.nextDouble(3.0) + 5.0;
    }

    public Jetsky(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, boolean canOperateInStorm, int amountOfPilots, double loudness) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, canOperateInStorm);
        this.amountOfPilots = amountOfPilots;
        this.loudness = loudness;
    }

    public Jetsky(Jetsky other) {
        super(other);
        this.amountOfPilots = other.amountOfPilots;
        this.loudness = other.loudness;
    }

    public int getAmountOfPilots() {
        return amountOfPilots;
    }

    public void setAmountOfPilots(int amountOfPilots) {
        this.amountOfPilots = amountOfPilots;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 200.0;

        if (amountOfPilots > 1) {
            basePrice *= amountOfPilots * 1.7;
        } else {
            basePrice *= amountOfPilots * 1.2;
        }

        if (maxPayload < 120) {
            basePrice *= 1.2;
        } else {
            basePrice *= 1.6;
        }

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton pilotsPlusButton = new JButton("Add Pilots");
        pilotsPlusButton.addActionListener(e -> {
            if (amountOfPilots <= 1) {
                ++amountOfPilots;
                JOptionPane.showMessageDialog(
                        null,
                        String.format("Number of pilots: %d", amountOfPilots),
                        "Adding Pilots ",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Maximum number of pilots reached",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(pilotsPlusButton);

        JButton pilotsMinusButton = new JButton("Remove Pilots");
        pilotsMinusButton.addActionListener(e -> {
            if (amountOfPilots > 1) {
                --amountOfPilots;
                JOptionPane.showMessageDialog(
                        null,
                        String.format("Number of pilots: %d", amountOfPilots),
                        "Removing Pilots",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Minimum number of pilots reached",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        actions.add(pilotsMinusButton);

        JButton infoButton = new JButton("Jetsky Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Jetsky Details:
                            Max payload: %dkg
                            Can operate in storm: %s
                            Amount of pilots: %d
                            Loudness: %.2f
                            Daily Price: $%.2f""",
                    maxPayload,
                    canOperateInStorm ? "Yes" : "No",
                    amountOfPilots,
                    loudness,
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Jetsky Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Jetsky{" +
               "amountOfPilots=" + amountOfPilots +
               ", loudnessl=" + loudness +
               '}';
    }
}

