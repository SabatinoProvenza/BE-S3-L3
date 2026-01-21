package sabatinoprovenza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sabatinoprovenza.dao.EventoDAO;
import sabatinoprovenza.dao.LocationDAO;
import sabatinoprovenza.dao.PartecipazioneDAO;
import sabatinoprovenza.dao.PersonaDAO;
import sabatinoprovenza.entities.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE-S3-L3pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        EventoDAO eventoDAO = new EventoDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

// 1) Location
        Location loc = new Location();
        loc.setNome("Sala Grande");
        loc.setCitta("Roma");
        locationDAO.save(loc);

// 2) Evento
        Evento ev = new Evento();
        ev.setTitolo("Java Night");
        ev.setTipoEvento(TipoEvento.PUBBLICO);
        ev.setNumeroMassimoPartecipanti(50);
        ev.setLocation(loc);
        eventoDAO.save(ev);

// 3) Persona
        Persona p = new Persona();
        p.setNome("Mario");
        p.setCognome("Rossi");
        p.setEmail("mario@rossi.it");
        p.setSesso(Sesso.M);
        personaDAO.save(p);

// 4) Partecipazione
        Partecipazione par = new Partecipazione();
        par.setPersona(p);
        par.setEvento(ev);
        par.setStatoPartecipazione(StatoPartecipazione.DA_CONFERMARE);
        partecipazioneDAO.save(par);

        em.close();
        emf.close();
    }
}
