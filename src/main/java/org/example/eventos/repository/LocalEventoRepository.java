package org.example.eventos.repository;

import org.example.eventos.model.LocalEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalEventoRepository extends JpaRepository<LocalEvento, Long> {
}
