package cartracker.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cartracker.entity.Alert;
import cartracker.entity.AlertType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mannu.
 */

@Repository
public class AlertTypeRepositoryImpl implements AlertTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public AlertType getAlertType(String id) {
        return entityManager.find(AlertType.class, id);
    }

    @Transactional
    public Alert createAlert(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

}
