package cartracker.controller;

import cartracker.entity.Vehicle;
import cartracker.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mannu.
 */

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    public void updateVehicle(@RequestBody Vehicle[] vehicles) {
        vehicleService.loadVehicles(vehicles);
    }

}
