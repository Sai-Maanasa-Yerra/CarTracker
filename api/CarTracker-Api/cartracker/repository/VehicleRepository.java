package cartracker.repository;

import java.util.List;

import cartracker.entity.Vehicle;

/**
 * Created by mannu.
 */
public interface VehicleRepository {

    public List<Vehicle> getVehicles();

    public Vehicle getVehicle(String vin);

    public Vehicle updateVehicle(Vehicle vehicle);

    public void createVehicle(Vehicle vehicle);
}
