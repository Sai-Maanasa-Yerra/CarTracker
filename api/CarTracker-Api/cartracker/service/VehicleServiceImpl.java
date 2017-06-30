package cartracker.service;

import cartracker.entity.Vehicle;
import cartracker.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mannu.
 */

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    public Vehicle getVehicle(String vin) {
        Vehicle existing =  vehicleRepository.getVehicle(vin);
        return existing;
    }

    public void loadVehicles(Vehicle[] vehicles) {
        for(Vehicle vehicle : vehicles) {
            Vehicle vExisting = getVehicle(vehicle.getVin());
            if(vExisting == null) {
                createVehicle(vehicle);
            } else {
                updateVehicle(vehicle);
            }
        }
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.updateVehicle(vehicle);
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.createVehicle(vehicle);
    }
}
