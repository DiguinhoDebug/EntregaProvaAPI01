package org.example.eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class LocalEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocal;

    private String nome;

    private String endereco;

    private Integer capacidade;

    @OneToMany(mappedBy = "Evento")
    private List<Evento> eventos;

}
