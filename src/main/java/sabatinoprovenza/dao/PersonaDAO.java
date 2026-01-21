package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sabatinoprovenza.entities.Persona;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newPersona);

        transaction.commit();

        System.out.println("La persona " + newPersona.getNome() + " è stato salvato correttamente!");
    }

    public Persona getById(String personaId) {
        Persona found = entityManager.find(Persona.class, UUID.fromString(personaId));
        return found;
    }
}
