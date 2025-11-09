package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Jetsky extends NavalVehicle {

    private int amountOfPilots;
    private double loudness;

    public Jetsky() {
        super();
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
    public double getDailyRentalPrice(){
        double basePrice = 200.0;

        if(amountOfPilots > 1){
            basePrice *= amountOfPilots * 1.7;
        } else{
            basePrice *= amountOfPilots * 1.2;
        }

        if(maxPayload < 120){
            basePrice *= 1.2;
        } else{
            basePrice *= 1.6;
        }

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions(){
        List<JButton> actions = new ArrayList<>();

        JButton pilotsPlusButton = new JButton("Add Pilots");
        pilotsPlusButton.addActionListener(e -> {
            if(amountOfPilots <= 1){
                ++amountOfPilots;
                JOptionPane.showMessageDialog(
                        null,
                        String.format("Number of pilots: %d", amountOfPilots),
                        "Adding Pilots ",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else{
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
            if(amountOfPilots > 1){
                --amountOfPilots;
                JOptionPane.showMessageDialog(
                        null,
                        String.format("Number of pilots: %d", amountOfPilots),
                        "Removing Pilots",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else {
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
            String info =String.format(
                    "Jetsky Details:\n"+
                            "Max payload: %dkg\n"+
                            "Can operate in storm: %s\n"+
                            "Amount of pilots: %d\n"+
                            "Loudness: %.2f\n"+
                            "Daily Price: $%.2f",
                    maxPayload,
                    canOperateInStorm  ? "Yes" : "No",
                    amountOfPilots,
                    loudness ,
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

