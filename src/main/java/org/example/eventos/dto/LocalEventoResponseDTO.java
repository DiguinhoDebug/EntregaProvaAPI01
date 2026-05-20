package org.example.eventos.dto;


import org.example.eventos.model.Evento;

import java.util.List;

public record LocalEventoResponseDTO(

        String nome,

        String endereco,

        Integer capacidade,

        List<Evento> evento
){
}
