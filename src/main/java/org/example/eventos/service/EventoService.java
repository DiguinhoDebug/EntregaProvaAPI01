package org.example.eventos.service;

import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.exception.RecursoNaoEncontradoException;
import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LocalEventoRepository localEventoRepository;

    public List<EventoResponseDTO> listarTodos() {
        return eventoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public EventoResponseDTO buscarPorId(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));

        return converterParaResponse(evento);
    }

    public EventoResponseDTO cadastrar(EventoRequestDTO dto) {
        LocalEvento localEvento = localEventoRepository.findById(dto.localId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Local do evento não encontrado"));
        //TODO: adicionar a exception

        Evento evento = new Evento();

        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setValorIngresso(dto.valorIngresso());
        evento.setIdLocalEvento(dto.localId());

        Evento salvo = eventoRepository.save(evento);

        return converterParaResponse(salvo);
    }

    public EventoResponseDTO atualizar(Long id, EventoRequestDTO dto) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));
        //TODO: adicionar a exception

        LocalEvento localEvento = localEventoRepository.findById(dto.localId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Local do evento não encontrado"));
        //TODO: adicionar a exception

        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setValorIngresso(dto.valorIngresso());
        evento.setIdLocalEvento(dto.localId());

        Evento atualizado = eventoRepository.save(evento);

        return converterParaResponse(atualizado);
    }

    public void deletar(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));
        //TODO: adicionar a exception

        eventoRepository.deleteById(id);
        //TODO: chamar método de deletar do repository
    }

    public List<EventoResponseDTO> listarPorLocal(Long idLocal) {
        return eventoRepository.findByLocal(idLocal)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public List<EventoResponseDTO> listarPorNome(String nome) {
        return eventoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private EventoResponseDTO converterParaResponse(Evento evento) {
        return new EventoResponseDTO(
                evento.getNome(),
                evento.getDescricao(),
                evento.getDataEvento(),
                evento.getValorIngresso(),
                evento.getIdLocalEvento()
                //TODO: fazer os gets de "inscricao" conforme o que deve aparecer no response
        );
    }
}
