package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalEventoRepository extends JpaRepository<LocalEvento, Long> {
    List<LocalEvento> findByNomeContainingIgnoreCase(String nome);
}
