package cartracker.service;

import java.util.List;

import cartracker.entity.Alert;

/**
 * Created by mannu.
 */

public interface AlertService {

    public List<Alert> getAllAlerts();

    public List<Alert> gethighAlerts(int hours);

}
