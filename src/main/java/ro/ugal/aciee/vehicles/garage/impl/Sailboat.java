package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sailboat extends NavalVehicle {

    private boolean sailsRaised;
    private boolean hasRudder;

    public Sailboat() {
        super();
    }

    public Sailboat(int year, int mileage, VehicleColor color, int maxPassengers,
                    boolean needsMaintenance, int maxPayload, boolean canOperateInStorm,
                    boolean sailsRaised, boolean hasRudder) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, canOperateInStorm);
        this.sailsRaised = sailsRaised;
        this.hasRudder = hasRudder;
    }

    public Sailboat(Sailboat other) {
        super(other);
        this.sailsRaised = other.sailsRaised;
        this.hasRudder = other.hasRudder;
    }

    public boolean isSailsRaised() {
        return sailsRaised;
    }

    public void setSailsRaised(boolean sailsRaised) {
        this.sailsRaised = sailsRaised;
    }

    public boolean isHasRudder() {
        return hasRudder;
    }

    public void setHasRudder(boolean hasRudder) {
        this.hasRudder = hasRudder;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 150.0;

        if (sailsRaised) {
            basePrice *= 1.3;
        }

        if (canOperateInStorm) {
            basePrice *= 1.4;
        }

        if (!hasRudder) {
            basePrice *= 0.8;
        }

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton sailsButton = new JButton(sailsRaised ? "Lower Sails" : "Raise Sails");
        sailsButton.addActionListener(e -> {
            sailsRaised = !sailsRaised;
            sailsButton.setText(sailsRaised ? "Lower Sails" : "Raise Sails");
            JOptionPane.showMessageDialog(null,
                    "Sails are now " + (sailsRaised ? "RAISED" : "LOWERED"),
                    "Sailboat Update",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(sailsButton);

        JButton rudderButton = new JButton(hasRudder ? "Remove Rudder" : "Attach Rudder");
        rudderButton.addActionListener(e -> {
            hasRudder = !hasRudder;
            rudderButton.setText(hasRudder ? "Remove Rudder" : "Attach Rudder");
            JOptionPane.showMessageDialog(null,
                    "Rudder is now " + (hasRudder ? "ATTACHED" : "REMOVED"),
                    "Sailboat Update",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(rudderButton);

        JButton infoButton = new JButton("Sailboat Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Sailboat Details:
                            Year: %d
                            Mileage: %d
                            Color: %s
                            Passengers: %d
                            Can operate in storm: %s
                            Sails raised: %s
                            Has rudder: %s
                            Daily Price: $%.2f""",
                    year, mileage, color, maxPassengers,
                    canOperateInStorm ? "Yes" : "No",
                    sailsRaised ? "Yes" : "No",
                    hasRudder ? "Yes" : "No",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null, info, "Sailboat Information", JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Sailboat{" +
               "sailsRaised=" + sailsRaised +
               ", hasRudder=" + hasRudder +
               '}';
    }
}
