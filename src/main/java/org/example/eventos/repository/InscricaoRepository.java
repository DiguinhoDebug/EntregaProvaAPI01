package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.example.eventos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository <Inscricao, Long> {

    List<Inscricao> findInscricaoByEvento(Evento evento);
    //TODO: criar método para listar inscrições de um determinado evento.
}
