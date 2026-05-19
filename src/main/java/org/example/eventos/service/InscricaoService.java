package org.example.eventos.service;

import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.exception.RecursoNaoEncontradoException;
import org.example.eventos.model.Evento;
import org.example.eventos.model.Inscricao;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<InscricaoResponseDTO> listarTodas() {
        return inscricaoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public InscricaoResponseDTO buscarPorId(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Inscrição não encontrada"));

        return converterParaResponse(inscricao);
    }

    public InscricaoResponseDTO cadastrar(InscricaoRequestDTO dto) {
        Evento evento = eventoRepository.findById(dto.idEvento())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));
                //TODO: adicionar a exception

        Inscricao inscricao = new Inscricao();

        inscricao.setNomeParticipante(dto.nomeParticipante());
        inscricao.setEmailParticipante(dto.emailParticipante());
        inscricao.setStatus(dto.status());
        inscricao.setEvento(evento);

        Inscricao salva = inscricaoRepository.save(inscricao);

        return converterParaResponse(salva);
    }

    public InscricaoResponseDTO atualizar(Long id, InscricaoRequestDTO dto) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Inscrição não encontrada"));
                //TODO: adicionar a exception

        Evento evento = eventoRepository.findById(dto.eventoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));
                //TODO: adicionar a exception

        inscricao.setNomeParticipante(dto.nomeParticipante());
        inscricao.setEmailParticipante(dto.emailParticipante());
        inscricao.setStatus(dto.status());
        inscricao.setEvento(evento);

        Inscricao atualizada = inscricaoRepository.save(inscricao);

        return converterParaResponse(atualizada);
    }

    public void deletar(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Inscrição não encontrada"));
                    //TODO: adicionar a exception

        inscricaoRepository.deleteById(id);
        //TODO: chamar método de deletar do repository
    }

    public List<InscricaoResponseDTO> listarPorEvento(Long idEvento) {
        return inscricaoRepository.findById(idEvento)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private InscricaoResponseDTO converterParaResponse(Inscricao inscricao) {
        Evento evento = eventoRepository.findById(idEvento())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));
        return new InscricaoResponseDTO(
                //TODO: fazer os gets de "inscricao" conforme o que deve aparecer no response
        );
    }
}