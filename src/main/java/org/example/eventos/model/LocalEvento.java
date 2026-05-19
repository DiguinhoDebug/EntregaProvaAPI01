package org.example.eventos.model;

import jakarta.persistence.*;

@Entity
public class LocalEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocal;

    private String nome;

    private String endereco;

    private Integer capacidade;

    public LocalEvento(){}

    public Long getIdLocal() {
        return idLocal;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
