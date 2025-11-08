package ro.ugal.aciee.vehicles.gui;

import ro.ugal.aciee.vehicles.garage.Vehicle;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class VehicleTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {
            "Type", "Year", "Color", "Passengers", "Mileage", "Daily Price", "Status"
    };

    private List<Vehicle> vehicles;

    public VehicleTableModel() {
        this.vehicles = new ArrayList<>();
    }

    public VehicleTableModel(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        fireTableDataChanged();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        fireTableRowsInserted(vehicles.size() - 1, vehicles.size() - 1);
    }

    public Vehicle getVehicleAt(int row) {
        if (row >= 0 && row < vehicles.size()) {
            return vehicles.get(row);
        }
        return null;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public int getRowCount() {
        return vehicles.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle vehicle = vehicles.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> vehicle.getClass().getSimpleName();
            case 1 -> vehicle.getYear();
            case 2 -> vehicle.getColor();
            case 3 -> vehicle.getMaxPassengers();
            case 4 -> vehicle.getMileage() + " km";
            case 5 -> String.format("$%.2f", vehicle.getDailyRentalPrice());
            case 6 -> vehicle.isNeedsMaintenance() ? "Maintenance" : vehicle.isRented() ? "Rented" : "Available";
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 2, 4, 5, 6 -> String.class;
            case 1, 3 -> Integer.class;
            default -> Object.class;
        };
    }
}
