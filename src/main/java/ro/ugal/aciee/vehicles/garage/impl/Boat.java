package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boat extends NavalVehicle {

    private boolean anchorDropped;
    private boolean hasCabin;

    public Boat() {
        super();
    }

    public Boat(boolean random) {
        this();

        if (!random) {
            return;
        }

        Random rand = new Random();

        this.year = rand.nextInt(240) + 1800;
        this.mileage = rand.nextInt(1500) + 2500;
        int index = rand.nextInt(VehicleColor.values().length);
        this.color = VehicleColor.values()[index];
        this.maxPassengers = rand.nextInt(10) + 4;
        this.needsMaintenance = rand.nextBoolean();
        this.maxPayload = rand.nextInt(100) + 350;
        this.canOperateInStorm = rand.nextBoolean();
        this.hasCabin = rand.nextBoolean();
        this.anchorDropped = rand.nextBoolean();
    }

    public Boat(int year, int mileage, VehicleColor color, int maxPassengers,
                boolean needsMaintenance, int maxPayload, boolean canOperateInStorm,
                boolean anchorDropped, boolean hasCabin) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, canOperateInStorm);
        this.anchorDropped = anchorDropped;
        this.hasCabin = hasCabin;
    }

    public Boat(Boat other) {
        super(other);
        this.anchorDropped = other.anchorDropped;
        this.hasCabin = other.hasCabin;
    }

    public boolean isAnchorDropped() {
        return anchorDropped;
    }

    public void setAnchorDropped(boolean anchorDropped) {
        this.anchorDropped = anchorDropped;
    }

    public boolean isHasCabin() {
        return hasCabin;
    }

    public void setHasCabin(boolean hasCabin) {
        this.hasCabin = hasCabin;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 100.0;

        if (hasCabin) {
            basePrice *= 1.2;
        }

        if (canOperateInStorm) {
            basePrice *= 1.5;
        }

        if (anchorDropped) {
            basePrice *= 0.9;
        }

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
                    "Boat Update",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(anchorButton);

        JButton cabinButton = new JButton(hasCabin ? "Remove Cabin" : "Add Cabin");
        cabinButton.addActionListener(e -> {
            hasCabin = !hasCabin;
            cabinButton.setText(hasCabin ? "Remove Cabin" : "Add Cabin");
            JOptionPane.showMessageDialog(null,
                    "Cabin status: " + (hasCabin ? "HAS CABIN" : "NO CABIN"),
                    "Boat Update",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(cabinButton);

        JButton infoButton = new JButton("Boat Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Boat Details:
                            Year: %d
                            Mileage: %d
                            Color: %s
                            Passengers: %d
                            Can operate in storm: %s
                            Anchor dropped: %s
                            Has cabin: %s
                            Daily Price: $%.2f""",
                    year, mileage, color, maxPassengers,
                    canOperateInStorm ? "Yes" : "No",
                    anchorDropped ? "Yes" : "No",
                    hasCabin ? "Yes" : "No",
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
                ", hasCabin=" + hasCabin +
                '}';
    }
}
