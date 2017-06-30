package cartracker.service;

import java.util.List;

import cartracker.entity.Reading;

/**
 * Created by mannu.
 */
public interface ReadingService {

    public List<Reading> getReadings();

    public List<Reading> getReadingsByVehicle(String vin);

    public Reading getReading(String id);

    public Reading addReading(Reading reading);

}
