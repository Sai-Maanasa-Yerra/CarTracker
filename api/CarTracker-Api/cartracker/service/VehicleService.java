package cartracker.service;

import java.util.List;

import cartracker.entity.Vehicle;

/**
 * Created by mannu.
 */
public interface VehicleService {

    public List<Vehicle> getVehicles();

    public Vehicle getVehicle(String vin);

    public void loadVehicles(Vehicle[] vehicles);

    public Vehicle updateVehicle(Vehicle vehicle);

    public void createVehicle(Vehicle vehicle);
}
