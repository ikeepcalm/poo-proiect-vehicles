package ro.ugal.aciee.vehicles.gui;

import ro.ugal.aciee.vehicles.garage.Vehicle;

import java.io.*;
import java.util.List;

public class FileManager {

    public static boolean saveVehicles(List<Vehicle> vehicles, String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(vehicles);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static List<Vehicle> loadVehicles(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (List<Vehicle>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

}
