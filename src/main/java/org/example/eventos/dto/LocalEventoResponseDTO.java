package org.example.eventos.dto;


import org.example.eventos.model.Evento;

public record LocalEventoResponseDTO(

        String nome,

        String endereco,

        Integer capacidade,

        Long idEvento
){
}
