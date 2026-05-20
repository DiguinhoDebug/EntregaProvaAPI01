package org.example.eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    private String nome;

    private String descricao;

    //exemplo = "2026-05-19"
    private LocalDate dataEvento;

    private Double valorIngresso;

    @ManyToOne
    @JoinColumn(name = "idLocal")
    private Long idLocalEvento;

    @OneToMany(mappedBy = "Inscricao")
    private List<Inscricao> inscricaos;

}


