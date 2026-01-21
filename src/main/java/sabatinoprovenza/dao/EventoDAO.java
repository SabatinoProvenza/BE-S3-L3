package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sabatinoprovenza.entities.Evento;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newEvento);

        transaction.commit();

        System.out.println("L'evento " + newEvento.getTitolo() + " è stato salvato correttamente!");
    }

    public Evento getById(String eventoId) {
        Evento found = entityManager.find(Evento.class, UUID.fromString(eventoId));
        return found;
    }
}
