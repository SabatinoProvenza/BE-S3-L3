package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sabatinoprovenza.entities.Location;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newLocation);

        transaction.commit();

        System.out.println("La location " + newLocation.getNome() + " è stata salvata correttamente!");
    }

    public Location getById(String locationId) {
        Location found = entityManager.find(Location.class, UUID.fromString(locationId));
        return found;
    }
}
