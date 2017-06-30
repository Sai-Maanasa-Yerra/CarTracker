package cartracker.controller;

import cartracker.entity.Alert;
import cartracker.service.AlertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mannu.
 */

@RestController
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/highalerts/{hours}")
    public List<Alert> gethighAlerts(@PathVariable("hours") int hours) {
        return alertService.gethighAlerts(hours);
    }

}
