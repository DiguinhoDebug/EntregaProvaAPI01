package org.example.eventos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InscricaoRequestDTO(
        @NotBlank(message = "Insira o nome do participante")
        String nomeParticipante,

        @Email(message = "Insira um email válido")
        @NotBlank(message = "Preencha o email, como iremos contatar você?!")
        String emailParticipante,

        @NotBlank(message = "Preencha o status!")
        String status,

        @NotNull(message = "Informe o evento da inscrição")
        Long idEvento
) {
}
