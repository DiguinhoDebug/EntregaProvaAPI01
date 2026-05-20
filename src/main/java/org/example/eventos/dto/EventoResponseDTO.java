package org.example.eventos.dto;

import org.example.eventos.model.LocalEvento;

import java.time.LocalDate;

public record EventoResponseDTO(

        String nome,

        String descricao,

        LocalDate dataEvento,

        Double valorIngresso,

        LocalEvento localEvento
) {
}
