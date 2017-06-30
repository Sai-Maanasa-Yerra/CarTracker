package cartracker.repository;

import java.util.List;

import cartracker.entity.Reading;

/**
 * Created by mannu.
 */
public interface ReadingRepository {

    public List<Reading> getReadings();

    public List<Reading> getReadingsByVehicle(String vin);

    public Reading getReading(String id);

    public Reading addReading(Reading reading);
}
