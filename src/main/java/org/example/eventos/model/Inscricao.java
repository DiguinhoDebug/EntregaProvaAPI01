package org.example.eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscricao;

    private String nomeParticipante;

    //pode-se usar o @Email para validar no DTO!
    private String emailParticipante;

    private String status;

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

}
