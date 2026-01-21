package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sabatinoprovenza.entities.Partecipazione;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newPartecipazione);

        transaction.commit();

        System.out.println("La partecipazione è stata salvata correttamente!");
    }

    public Partecipazione getById(String partecipazioneId) {
        Partecipazione found = entityManager.find(Partecipazione.class, UUID.fromString(partecipazioneId));
        return found;
    }
}
