package cartracker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cartracker.entity.Alert;

/**
 * Created by mannu.
 */

@Repository
public class AlertRepositoryImpl implements AlertRepository {
	
	@PersistenceContext
    private EntityManager entityManager;

	 @Transactional(readOnly = true)
    public List<Alert> getAllAlerts() {
		 TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.getAll",Alert.class);
	        return query.getResultList();
    }

}
