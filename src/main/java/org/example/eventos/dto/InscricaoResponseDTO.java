package org.example.eventos.dto;

import org.example.eventos.model.Evento;

public record InscricaoResponseDTO(

        String nomeParticipante,

        String emailParticipante,

        String status,

        Evento evento
) {
}
