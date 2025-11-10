package ro.ugal.aciee.vehicles.gui;

import ro.ugal.aciee.vehicles.garage.Vehicle;
import ro.ugal.aciee.vehicles.garage.impl.*;
import ro.ugal.aciee.vehicles.garage.source.VehicleColor;
import ro.ugal.aciee.vehicles.service.VehicleFleet;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;
import java.util.Random;


public class VehicleRentalGUI extends JFrame {

    private VehicleFleet fleet;
    private VehicleTableModel tableModel;
    private JTable vehicleTable;
    private VehicleDetailsPanel detailsPanel;

    private JComboBox<String> colorFilterCombo;
    private JSpinner yearFilterSpinner;
    private JTextField priceFilterField;
    private JTextField passengersFilterField;
    private JSpinner daysSpinner;
    private JTextField budgetField;

    private JLabel totalVehiclesLabel;
    private JLabel availableVehiclesLabel;

    Random random = new Random();

    public VehicleRentalGUI(VehicleFleet fleet) {
        this.fleet = fleet;
        initializeGUI();
        loadVehicles();
        updateStatusLabels();
    }

    private void initializeGUI() {
        setTitle("Vehicle Rental Fleet Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        createMenuBar();
        createNorthPanel();
        createCenterPanel();
        createSouthPanel();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu loadSaveVehicles = new JMenu("Load & Save Vehicles");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        saveMenuItem.addActionListener(e -> {
            if (fleet != null) {
                JFileChooser chooser = new JFileChooser();

                int returnVal = chooser.showSaveDialog(this);
                if (returnVal != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                String filePath = chooser.getSelectedFile().getAbsolutePath();

                if (!filePath.trim().isEmpty()) {
                    if (FileManager.saveVehicles(fleet.getAllVehicles(), filePath)) {
                        JOptionPane.showMessageDialog(this, "Vehicles saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        loadMenuItem.addActionListener(e -> {

            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filePath = chooser.getSelectedFile().getAbsolutePath();
                List<Vehicle> loadedVehicles = FileManager.loadVehicles(filePath);
                if (loadedVehicles != null) {
                    this.fleet = new VehicleFleet(loadedVehicles);
                    JOptionPane.showMessageDialog(this, "Vehicles loaded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    loadVehicles();
                    updateStatusLabels();
                }
            }
        });
        exitMenuItem.addActionListener(e -> System.exit(0));

        loadSaveVehicles.add(saveMenuItem);
        loadSaveVehicles.add(loadMenuItem);
        loadSaveVehicles.add(exitMenuItem);
        menuBar.add(loadSaveVehicles);
        setJMenuBar(menuBar);
    }

    private void createNorthPanel() {
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalVehiclesLabel = new JLabel("Total: 0");
        availableVehiclesLabel = new JLabel("Available: 0");
        statusPanel.add(new JLabel("Fleet Status - "));
        statusPanel.add(totalVehiclesLabel);
        statusPanel.add(new JLabel(" | "));
        statusPanel.add(availableVehiclesLabel);

        JPanel filterPanel = new JPanel(new GridBagLayout());
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filters"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        filterPanel.add(new JLabel("Color:"), gbc);

        gbc.gridx = 1;
        String[] colors = {"All", "RED", "GREEN", "BLUE", "YELLOW", "WHITE", "BLACK", "GRAY", "PINK"};
        colorFilterCombo = new JComboBox<>(colors);
        filterPanel.add(colorFilterCombo, gbc);

        gbc.gridx = 2;
        filterPanel.add(new JLabel("Year:"), gbc);

        gbc.gridx = 3;
        yearFilterSpinner = new JSpinner(new SpinnerNumberModel(2020, 1990, 2025, 1));
        filterPanel.add(yearFilterSpinner, gbc);

        gbc.gridx = 4;
        filterPanel.add(new JLabel("Max Price:"), gbc);

        gbc.gridx = 5;
        priceFilterField = new JTextField(8);
        priceFilterField.setToolTipText("Enter maximum daily price");
        filterPanel.add(priceFilterField, gbc);

        gbc.gridx = 6;
        filterPanel.add(new JLabel("Min Passengers:"), gbc);

        gbc.gridx = 7;
        passengersFilterField = new JTextField(8);
        passengersFilterField.setToolTipText("Enter minimum passengers");
        filterPanel.add(passengersFilterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        filterPanel.add(new JLabel("Rental Days:"), gbc);

        gbc.gridx = 1;
        daysSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 365, 1));
        filterPanel.add(daysSpinner, gbc);

        gbc.gridx = 2;
        filterPanel.add(new JLabel("Total Budget:"), gbc);

        gbc.gridx = 3;
        budgetField = new JTextField(8);
        budgetField.setToolTipText("Enter total budget for rental period");
        filterPanel.add(budgetField, gbc);

        gbc.gridx = 4;
        JButton applyBasicFilterBtn = new JButton("Filter by Properties");
        applyBasicFilterBtn.addActionListener(e -> applyBasicFilters());
        filterPanel.add(applyBasicFilterBtn, gbc);

        gbc.gridx = 5;
        JButton applyBudgetFilterBtn = new JButton("Filter by Budget");
        applyBudgetFilterBtn.addActionListener(e -> applyBudgetFilter());
        filterPanel.add(applyBudgetFilterBtn, gbc);

        gbc.gridx = 6;
        JButton showAllBtn = new JButton("Show All");
        showAllBtn.addActionListener(e -> showAllVehicles());
        filterPanel.add(showAllBtn, gbc);

        gbc.gridx = 7;
        JButton showAvailableBtn = new JButton("Available Only");
        showAvailableBtn.addActionListener(e -> showAvailableOnly());
        filterPanel.add(showAvailableBtn, gbc);

        northPanel.add(statusPanel, BorderLayout.NORTH);
        northPanel.add(filterPanel, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);
    }

    private void createCenterPanel() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        tableModel = new VehicleTableModel();
        vehicleTable = new JTable(tableModel);
        vehicleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vehicleTable.setRowHeight(25);
        vehicleTable.getTableHeader().setReorderingAllowed(false);

        TableRowSorter<VehicleTableModel> sorter = new TableRowSorter<>(tableModel);
        vehicleTable.setRowSorter(sorter);

        vehicleTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = vehicleTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int modelRow = vehicleTable.convertRowIndexToModel(selectedRow);
                    Vehicle vehicle = tableModel.getVehicleAt(modelRow);
                    detailsPanel.displayVehicle(vehicle);
                }
            }
        });

        JScrollPane tableScrollPane = new JScrollPane(vehicleTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Vehicle List"));

        detailsPanel = new VehicleDetailsPanel();

        splitPane.setTopComponent(tableScrollPane);
        splitPane.setBottomComponent(detailsPanel);
        splitPane.setDividerLocation(200);

        add(splitPane, BorderLayout.CENTER);
    }

    private void createSouthPanel() {
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        southPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        JButton rentButton = new JButton("Rent Vehicle");
        rentButton.setPreferredSize(new Dimension(150, 35));
        rentButton.addActionListener(e -> rentVehicle());

        JButton returnButton = new JButton("Return Vehicle");
        returnButton.setPreferredSize(new Dimension(150, 35));
        returnButton.addActionListener(e -> returnVehicle());

        JButton maintenanceButton = new JButton("Toggle Maintenance");
        maintenanceButton.setPreferredSize(new Dimension(180, 35));
        maintenanceButton.addActionListener(e -> toggleMaintenance());

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(120, 35));
        refreshButton.addActionListener(e -> refreshAll());

        JButton clearButton = new JButton("Remove All");
        clearButton.setPreferredSize(new Dimension(120, 35));
        clearButton.addActionListener(e -> clearAll());

        JButton generateButton = new JButton("Generate new vehicle");
        generateButton.setPreferredSize(new Dimension(120, 35));
        generateButton.addActionListener(e -> generateNewVehicle());

        southPanel.add(rentButton);
        southPanel.add(returnButton);
        southPanel.add(maintenanceButton);
        southPanel.add(refreshButton);
        southPanel.add(clearButton);
        southPanel.add(generateButton);

        add(southPanel, BorderLayout.SOUTH);
    }

    private void generateNewVehicle() {
        if (random.nextBoolean()) {
            fleet.addAerialVehicle(new Airplane(true));
        } else {
            fleet.addAerialVehicle(new Jetplane(true));
        }

        loadVehicles();
        refreshAll();
    }

    private void clearAll() {
        tableModel.setVehicles(List.of());
        fleet = new VehicleFleet();
        updateStatusLabels();
    }

    private void loadVehicles() {
        List<Vehicle> allVehicles = fleet.getAllVehicles();
        tableModel.setVehicles(allVehicles);
    }

    private void showAllVehicles() {
        loadVehicles();
        updateStatusLabels();
    }

    private void showAvailableOnly() {
        List<Vehicle> allVehicles = fleet.getAllVehicles();
        List<Vehicle> available = allVehicles.stream()
                .filter(v -> !v.isRented() && !v.isNeedsMaintenance())
                .toList();
        tableModel.setVehicles(available);
        updateStatusLabels();
    }

    private void applyBasicFilters() {
        try {
            String selectedColor = (String) colorFilterCombo.getSelectedItem();
            int year = (int) yearFilterSpinner.getValue();

            if ("All".equals(selectedColor)) {
                List<Vehicle> filtered = fleet.getAllVehicles().stream()
                        .filter(v -> v.getYear() < year)
                        .toList();
                tableModel.setVehicles(filtered);
            } else {
                VehicleColor color = VehicleColor.valueOf(selectedColor);
                List<Vehicle> filtered = fleet.getVehiclesByColorAndYear(color, year);
                tableModel.setVehicles(filtered);
            }

            if (!priceFilterField.getText().trim().isEmpty() && !passengersFilterField.getText().trim().isEmpty()) {
                double maxPrice = Double.parseDouble(priceFilterField.getText().trim());
                int minPassengers = Integer.parseInt(passengersFilterField.getText().trim());

                List<Vehicle> currentVehicles = tableModel.getVehicles();
                List<Vehicle> doubleFiltered = fleet.getVehiclesByMaxPassengersAndDailyPrice(minPassengers, maxPrice).stream()
                        .filter(currentVehicles::contains)
                        .toList();
                tableModel.setVehicles(doubleFiltered);
            }

            updateStatusLabels();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid filter values: " + ex.getMessage(),
                    "Filter Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void applyBudgetFilter() {
        try {
            int days = (int) daysSpinner.getValue();
            double budget = Double.parseDouble(budgetField.getText().trim());

            List<Vehicle> filtered = fleet.getVehiclesByDaysAndBudget(days, budget);
            tableModel.setVehicles(filtered);
            updateStatusLabels();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid budget filter values: " + ex.getMessage(),
                    "Filter Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rentVehicle() {
        Vehicle selected = detailsPanel.getCurrentVehicle();
        if (selected == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select a vehicle first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selected.isRented()) {
            JOptionPane.showMessageDialog(this,
                    "This vehicle is already rented.",
                    "Already Rented",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selected.isNeedsMaintenance()) {
            JOptionPane.showMessageDialog(this,
                    "This vehicle needs maintenance and cannot be rented.",
                    "Maintenance Required",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String customerName = JOptionPane.showInputDialog(this,
                "Enter customer name:",
                "Rent Vehicle",
                JOptionPane.QUESTION_MESSAGE);

        if (customerName != null && !customerName.trim().isEmpty()) {
            boolean success = selected.rent(customerName.trim());
            if (success) {
                refreshAll();
                JOptionPane.showMessageDialog(this,
                        "Vehicle rented successfully to " + customerName,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to rent vehicle.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void returnVehicle() {
        Vehicle selected = detailsPanel.getCurrentVehicle();
        if (selected == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select a vehicle first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!selected.isRented()) {
            JOptionPane.showMessageDialog(this,
                    "This vehicle is not currently rented.",
                    "Not Rented",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Return vehicle from " + selected.getCurrentRenterName() + "?",
                "Confirm Return",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = selected.returnVehicle();
            if (success) {
                refreshAll();
                JOptionPane.showMessageDialog(this,
                        "Vehicle returned successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to return vehicle.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void toggleMaintenance() {
        Vehicle selected = detailsPanel.getCurrentVehicle();
        if (selected == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select a vehicle first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        selected.setNeedsMaintenance(!selected.isNeedsMaintenance());
        refreshAll();
    }

    private void refreshAll() {
        tableModel.fireTableDataChanged();
        detailsPanel.refresh();
        updateStatusLabels();
    }

    private void updateStatusLabels() {
        totalVehiclesLabel.setText("Total: " + fleet.getTotalVehicleCount());
        availableVehiclesLabel.setText("Available: " + fleet.getAvailableVehicleCount());
    }

    public void launch() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
