package ro.ugal.aciee.vehicles.garage.impl;

import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.garage.types.RollingVehicle;

import javax.swing.*;
import java.util.List;

public class Truck extends RollingVehicle {

    private boolean isTrailerAttached;

    public Truck() {
        super();
    }

    public Truck(boolean electric, int horsePower, int maxSpeedKmh, boolean isTrailerAttached) {
        super(electric, horsePower, maxSpeedKmh);
        this.isTrailerAttached = isTrailerAttached;
    }

    public Truck(int year, int mileage, VehicleColor color, int maxPassengers, boolean needsMaintenance, boolean electric, int horsePower, int maxSpeedKmh, boolean isTrailerAttached) {
        super(year, mileage, color, maxPassengers, needsMaintenance, electric, horsePower, maxSpeedKmh);
        this.isTrailerAttached = isTrailerAttached;
    }

    public Truck(Truck other) {
        super(other);
        this.isTrailerAttached = other.isTrailerAttached;
    }

    public boolean isTrailerAttached() {
        return isTrailerAttached;
    }

    public void setTrailerAttached(boolean trailerAttached) {
        isTrailerAttached = trailerAttached;
    }

    @Override
    public List<JButton> getInteractiveActions() {
        List<JButton> actions = super.getInteractiveActions();

        JButton attachTrailerButton = new JButton(isTrailerAttached ? "Detach Trailer" : "Attach Trailer");

        attachTrailerButton.addActionListener(e -> {
            this.isTrailerAttached = !this.isTrailerAttached;
            attachTrailerButton.setText(isTrailerAttached ? "Detach Trailer" : "Attach Trailer");

            JOptionPane.showMessageDialog(null,
                    isTrailerAttached ? "Trailer has been attached." : "Trailer has been detached.",
                    "Trailer Attachment",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        JButton gasolineButton = new JButton("Gasoline");
        gasolineButton.addActionListener(e -> {
            this.electric = !this.electric;
            gasolineButton.setText(this.electric ? "Electric" : "Gasoline");

            JOptionPane.showMessageDialog(null,
                    this.electric ? "Electric engine has been selected." : "Gasoline engine has been selected.",
                    "Electric/Gasoline",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        actions.add(attachTrailerButton);
        actions.add(gasolineButton);

        return actions;
    }

    @Override
    public double getDailyRentalPrice() {
        double basePrice = 15.0;

        if (this.isTrailerAttached) {
            basePrice *= 2;
        }

        if (this.electric) {
            basePrice *= 0.7;
        }

        basePrice *= this.horsePower / 50.0;

        return basePrice;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "isTrailerAttached=" + isTrailerAttached +
                '}';
    }
}
