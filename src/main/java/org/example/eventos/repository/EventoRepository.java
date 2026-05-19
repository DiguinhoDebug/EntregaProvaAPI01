package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository <Evento, Long> {

    List<Evento> findByNomeContainingIgnoreCase(String nome);

    List<Evento> findByLocal(LocalEvento local);
    // TODO: criar método para filtrar eventos pelo nome.

    //TODO: criar método para listar eventos de um determinado local.

}
