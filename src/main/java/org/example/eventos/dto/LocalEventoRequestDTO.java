package org.example.eventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LocalEventoRequestDTO(

        @NotBlank(message = "O nome do local é obrigatório")
        String nome,

        @NotBlank(message = "O endereço é obrigatório")
        String endereco,

        @NotNull(message = "A capacidade é obrigatória")
        @Positive(message = "A capacidade deve ser maior que zero")
        Integer capacidade,

        @Positive(message = "Insira um valor positivo")
        @NotNull(message = "Preencha a qual evento o local irá armazenar")
        Long idEvento
) {
}
