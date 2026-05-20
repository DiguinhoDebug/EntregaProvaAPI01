package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository <Evento, Long> {

    List<Evento> findByNomeContainingIgnoreCase(String nome);

    List<Evento> findByLocal(Long idLocal);
}
