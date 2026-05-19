package org.example.eventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record EventoRequestDTO(

        @NotBlank(message = "Preencha o nome")
        String nome,

        @NotBlank(message = "Preencha a descrição do evento")
        String descricao,

        @NotEmpty(message = "Preencha a data do evento")
        LocalDate dataEvento,

        @NotNull(message = "Informe o valor do ingresso")
        @Positive(message = "Insira um valor válido")
        Double valorIngresso,

        @NotNull(message = "Informe o local do evento")
        @Positive(message = "Insira um id válido")
        Long localId
) {
}
