package cartracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cartracker.entity.Alert;
import cartracker.entity.AlertType;
import cartracker.entity.Reading;
import cartracker.entity.Tire;
import cartracker.entity.Vehicle;
import cartracker.repository.ReadingRepository;

/**
 * Created by mannu.
 */

@Service
public class ReadingServiceImpl implements ReadingService {
	

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    AlertTypeService alertTypeService;

    public List<Reading> getReadings() {
        return readingRepository.getReadings();
    }

    public List<Reading> getReadingsByVehicle(String vin) {
        return readingRepository.getReadingsByVehicle(vin);
    }

    public Reading getReading(String id) {
        return readingRepository.getReading(id);
    }

    public Reading addReading(Reading reading) {
        readingRepository.addReading(reading);
        Vehicle vehicle =  vehicleService.getVehicle(reading.getVin());
        System.out.println(vehicle+"hello");
        if(vehicle != null) {
            if (reading.getEngineRpm() > vehicle.getRedLineRpm()) {
                createAlert("at-01", reading);
            }
            if (reading.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())) {
                createAlert("at-02", reading);
            }
            if (getLeastTirePressure(reading.getTires()) < 32 || getMaxTirePressure(reading.getTires()) > 36) {
                createAlert("at-03", reading);
            }
            if (reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()) {
                createAlert("at-04", reading);
            }
        }
        return reading;
    }

    public int getLeastTirePressure(Tire tireSet) {
        int leastValue = Integer.MAX_VALUE;
        if(tireSet.getFrontLeft() < leastValue)
            leastValue = tireSet.getFrontLeft();
        if(tireSet.getFrontRight() < leastValue)
            leastValue = tireSet.getFrontRight();
        if(tireSet.getRearLeft() < leastValue)
            leastValue = tireSet.getRearLeft();
        if(tireSet.getRearRight() < leastValue)
            leastValue = tireSet.getRearRight();
        return leastValue;
    }

    public int getMaxTirePressure(Tire tireSet) {
        int maxValue = Integer.MIN_VALUE;
        if(tireSet.getFrontLeft() > maxValue)
            maxValue = tireSet.getFrontLeft();
        if(tireSet.getFrontRight() > maxValue)
            maxValue = tireSet.getFrontRight();
        if(tireSet.getRearLeft() > maxValue)
            maxValue = tireSet.getRearLeft();
        if(tireSet.getRearRight() > maxValue)
            maxValue = tireSet.getRearRight();
        return maxValue;
    }

    public void createAlert(String alertTypeId, Reading reading) {
        Alert alert = new Alert();
        alert.setReading(reading);
        AlertType alertType = (alertTypeService.getAlertType(alertTypeId));
        alert.setType(alertType);
        alertTypeService.createAlert(alert);
    }

}
