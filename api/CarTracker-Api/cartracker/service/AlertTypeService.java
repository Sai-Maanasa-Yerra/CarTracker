package cartracker.service;

import cartracker.entity.Alert;
import cartracker.entity.AlertType;

/**
 * Created by mannu.
 */

public interface AlertTypeService {

    public AlertType getAlertType(String id);

    public Alert createAlert(Alert alert);

}
