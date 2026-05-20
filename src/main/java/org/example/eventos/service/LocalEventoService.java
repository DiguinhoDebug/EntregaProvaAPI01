package org.example.eventos.service;

import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.dto.LocalEventoRequestDTO;
import org.example.eventos.dto.LocalEventoResponseDTO;
import org.example.eventos.exception.RecursoNaoEncontradoException;
import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalEventoService {
    @Autowired
    private LocalEventoRepository localEventoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<LocalEventoResponseDTO> listarTodos() {
        return localEventoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public LocalEventoResponseDTO buscarPorId(Long id) {
       LocalEvento localEvento = localEventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Local do evento não encontrado"));

        return converterParaResponse(localEvento);
    }

    public LocalEventoResponseDTO cadastrar(LocalEventoRequestDTO dto) {
        LocalEvento localEvento = new LocalEvento();

        localEvento.setNome(dto.nome());
        localEvento.setEndereco(dto.endereco());
        localEvento.setCapacidade(dto.capacidade());

        LocalEvento salvo = localEventoRepository.save(localEvento);


        return converterParaResponse(salvo);
    }

    public LocalEventoResponseDTO atualizar(Long id, LocalEventoRequestDTO dto) {
        LocalEvento localEvento = localEventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Local do evento não encontrado"));

        localEvento.setNome(dto.nome());
        localEvento.setEndereco(dto.endereco());
        localEvento.setCapacidade(dto.capacidade());

        LocalEvento atualizado = localEventoRepository.save(localEvento);

        return converterParaResponse(atualizado);
    }

    public void deletar(Long id) {
        LocalEvento localEvento = localEventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Local do evento não encontrado"));

       localEventoRepository.deleteById(id);
    }

    public List<LocalEventoResponseDTO> listarPorNome(String nome) {
        return localEventoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private LocalEventoResponseDTO converterParaResponse(LocalEvento localEvento) {
        return new LocalEventoResponseDTO(
                localEvento.getNome(),
                localEvento.getEndereco(),
                localEvento.getCapacidade(),
                localEvento.getEventos()
        );
    }
}
