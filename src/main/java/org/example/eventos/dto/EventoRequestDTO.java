package org.example.eventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoRequestDTO(

        //TODO: colocar validações de entrada de dados
        String nome,

        String descricao,

        LocalDate dataEvento,

        Double valorIngresso,

        Long localId
) {
}
