package ro.ugal.aciee.vehicles.gui;

import ro.ugal.aciee.vehicles.garage.Vehicle;

import javax.swing.*;
import java.awt.*;

public class VehicleDetailsPanel extends JPanel {

    private JLabel typeLabel;
    private JLabel yearLabel;
    private JLabel mileageLabel;
    private JLabel colorLabel;
    private JLabel passengersLabel;
    private JLabel statusLabel;
    private JLabel renterLabel;
    private JLabel maintenanceLabel;
    private JLabel priceLabel;
    private JPanel actionButtonsPanel;

    private Vehicle currentVehicle;

    public VehicleDetailsPanel() {
        setLayout(new BorderLayout(10, 10));

        setBorder(BorderFactory.createTitledBorder("Vehicle Details"));

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel infoPanel = new JPanel(new GridLayout(9, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        typeLabel = new JLabel("-");
        yearLabel = new JLabel("-");
        mileageLabel = new JLabel("-");
        colorLabel = new JLabel("-");
        passengersLabel = new JLabel("-");
        statusLabel = new JLabel("-");
        renterLabel = new JLabel("-");
        maintenanceLabel = new JLabel("-");
        priceLabel = new JLabel("-");

        infoPanel.add(new JLabel("Type:"));
        infoPanel.add(typeLabel);
        infoPanel.add(new JLabel("Year:"));
        infoPanel.add(yearLabel);
        infoPanel.add(new JLabel("Mileage:"));
        infoPanel.add(mileageLabel);
        infoPanel.add(new JLabel("Color:"));
        infoPanel.add(colorLabel);
        infoPanel.add(new JLabel("Max Passengers:"));
        infoPanel.add(passengersLabel);
        infoPanel.add(new JLabel("Status:"));
        infoPanel.add(statusLabel);
        infoPanel.add(new JLabel("Rented To:"));
        infoPanel.add(renterLabel);
        infoPanel.add(new JLabel("Needs Maintenance:"));
        infoPanel.add(maintenanceLabel);
        infoPanel.add(new JLabel("Daily Price:"));
        infoPanel.add(priceLabel);

        actionButtonsPanel = new JPanel();
        actionButtonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        actionButtonsPanel.setBorder(BorderFactory.createTitledBorder("Interactive Actions"));

        add(infoPanel, BorderLayout.CENTER);
        add(actionButtonsPanel, BorderLayout.SOUTH);

        clearDetails();
    }

    public void displayVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            clearDetails();
            return;
        }

        this.currentVehicle = vehicle;

        typeLabel.setText(vehicle.getClass().getSimpleName());
        yearLabel.setText(String.valueOf(vehicle.getYear()));
        mileageLabel.setText(vehicle.getMileage() + " km");
        colorLabel.setText(String.valueOf(vehicle.getColor()));
        passengersLabel.setText(String.valueOf(vehicle.getMaxPassengers()));

        if (vehicle.isNeedsMaintenance()) {
            statusLabel.setText("Needs Maintenance");
            statusLabel.setForeground(Color.ORANGE);
        } else if (vehicle.isRented()) {
            statusLabel.setText("Rented");
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setText("Available");
            statusLabel.setForeground(Color.GREEN);
        }

        renterLabel.setText(vehicle.isRented() ? vehicle.getCurrentRenterName() : "-");
        maintenanceLabel.setText(vehicle.isNeedsMaintenance() ? "Yes" : "No");
        priceLabel.setText(String.format("$%.2f", vehicle.getDailyRentalPrice()));

        loadActionButtons();
    }

    private void loadActionButtons() {
        actionButtonsPanel.removeAll();

        if (currentVehicle != null) {
            for (JButton button : currentVehicle.getInteractiveActions()) {
                actionButtonsPanel.add(button);
            }
        }

        actionButtonsPanel.revalidate();
        actionButtonsPanel.repaint();
    }

    public void clearDetails() {
        this.currentVehicle = null;

        typeLabel.setText("-");
        yearLabel.setText("-");
        mileageLabel.setText("-");
        colorLabel.setText("-");
        passengersLabel.setText("-");
        statusLabel.setText("-");
        statusLabel.setForeground(Color.BLACK);
        renterLabel.setText("-");
        maintenanceLabel.setText("-");
        priceLabel.setText("-");

        actionButtonsPanel.removeAll();
        actionButtonsPanel.revalidate();
        actionButtonsPanel.repaint();
    }

    public void refresh() {
        if (currentVehicle != null) {
            displayVehicle(currentVehicle);
        }
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
