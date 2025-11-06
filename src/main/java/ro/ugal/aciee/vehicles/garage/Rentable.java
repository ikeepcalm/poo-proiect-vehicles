package ro.ugal.aciee.vehicles.garage;

public interface Rentable {

    boolean rent(String customerName);

    boolean returnVehicle();

    boolean isRented();

    double getDailyRentalPrice();

    double calculateRentalCost(int days);
}
