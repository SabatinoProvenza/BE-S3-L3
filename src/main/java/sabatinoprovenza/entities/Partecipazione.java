package sabatinoprovenza.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statoPartecipazione;
}
