package cartracker.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cartracker.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mannu.
 */

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.getAll",Vehicle.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Vehicle getVehicle(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    @Transactional
    public void createVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

}
