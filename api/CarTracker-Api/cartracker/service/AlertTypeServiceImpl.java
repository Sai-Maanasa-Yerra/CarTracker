package cartracker.service;

import cartracker.entity.Alert;
import cartracker.entity.AlertType;
import cartracker.repository.AlertTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mannu.
 */

@Service
public class AlertTypeServiceImpl implements AlertTypeService {

    @Autowired
    AlertTypeRepository alertTypeRepository;

    public AlertType getAlertType(String id) {
        return alertTypeRepository.getAlertType(id);
    }

    public Alert createAlert(Alert alert) {
        return alertTypeRepository.createAlert(alert);
    }
}
