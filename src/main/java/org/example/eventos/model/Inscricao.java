package org.example.eventos.model;

public class Inscricao {

    private Long idInscricao;

    private String nomeParticipante;

    //pode-se usar o @Email para validar no DTO!
    private String emailParticipante;

    private String status;

    //TODO: transformar em entidade e colocar relacionamento

}
