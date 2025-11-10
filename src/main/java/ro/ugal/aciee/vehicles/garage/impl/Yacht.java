package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.NavalVehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Yacht extends NavalVehicle {

    private boolean hasPool;
    private boolean sailsRaised;

    public Yacht() {
        super();
    }

    public Yacht(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, int maxPayload, boolean canOperateInStorm, boolean hasPool, boolean sailsRaised) {
        super(year, mileage, color, maxPassengers, needsMaintenance, maxPayload, canOperateInStorm);
        this.hasPool = hasPool;
        this.sailsRaised = sailsRaised;
    }

    public Yacht(Yacht other) {
        super(other);
        this.hasPool = other.hasPool;
        this.sailsRaised = other.sailsRaised;
    }

    public boolean getIsHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean getIsSailsRaised() {
        return sailsRaised;
    }

    public void setSailsRaised(boolean sailsRaised) {
        this.sailsRaised = sailsRaised;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 500.0;

        if (hasPool) {
            basePrice *= 1.3;
        }

        if (canOperateInStorm) {
            basePrice *= 2;
        }

        return basePrice;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = new ArrayList<>();

        JButton poolButton = new JButton(hasPool ? "Disable pool" : "Enable pool");
        poolButton.addActionListener(e -> {
            hasPool = !hasPool;
            poolButton.setText(hasPool ? "Disable pool" : "Enable pool");
            JOptionPane.showMessageDialog(null,
                    "Yacht is now has pool: " + (hasPool ? "ENABLE" : "DISABLE"),
                    "Yacht Status Updated",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(poolButton);

        JButton infoButton = new JButton("Yacht Info");
        infoButton.addActionListener(e -> {
            String info = String.format(
                    """
                            Yacht Details:
                            Max payload: %dkg
                            Can operate in storm: %s
                            Has pool: %s
                            Sails raised: %s
                            Daily Price: $%.2f""",
                    maxPayload,
                    canOperateInStorm ? "Yes" : "No",
                    hasPool ? "Yes" : "No",
                    sailsRaised ? "Yes" : "No",
                    getDailyRentalPrice()
            );
            JOptionPane.showMessageDialog(null,
                    info,
                    "Yacht Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        actions.add(infoButton);

        return actions;
    }

    @Override
    public String toString() {
        return "Yacht{" +
               "hasPool=" + hasPool +
               ", sailsRaised=" + sailsRaised +
               '}';
    }
}


