package org.example.eventos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inscricao {

    private Long idInscricao;

    private String nomeParticipante;

    //pode-se usar o @Email para validar no DTO!
    private String emailParticipante;

    private String status;

    //TODO: transformar em entidade e colocar relacionamento
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Long idEvento;

}
