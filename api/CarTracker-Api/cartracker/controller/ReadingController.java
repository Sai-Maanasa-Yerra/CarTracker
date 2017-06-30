package cartracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cartracker.entity.Reading;
import cartracker.service.ReadingService;

/**
 * Created by mannu .
 */

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> getReadings() {
        return readingService.getReadings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Reading> getReadings(@PathVariable("vin") String vin) {
        return readingService.getReadingsByVehicle(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public void createReading(@RequestBody Reading reading) {
        readingService.addReading(reading);
    }

}
