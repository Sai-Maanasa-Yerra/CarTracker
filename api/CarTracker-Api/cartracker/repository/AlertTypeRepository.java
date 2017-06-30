package cartracker.repository;

import cartracker.entity.Alert;
import cartracker.entity.AlertType;

/**
 * Created by mannu.
 */

public interface AlertTypeRepository {

    public AlertType getAlertType(String id);

    public Alert createAlert(Alert alert);

}
