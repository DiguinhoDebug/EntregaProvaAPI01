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
        Evento evento = eventoRepository.findById(dto.evento().getIdEvento())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));

        Inscricao inscricao = new Inscricao();

        inscricao.setNomeParticipante(dto.nomeParticipante());
        inscricao.setEmailParticipante(dto.emailParticipante());
        inscricao.setStatus(dto.status());
        inscricao.setEvento(dto.evento());

        Inscricao salva = inscricaoRepository.save(inscricao);

        return converterParaResponse(salva);
    }

    public InscricaoResponseDTO atualizar(Long id, InscricaoRequestDTO dto) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Inscrição não encontrada"));

        Evento evento = eventoRepository.findById(dto.evento().getIdEvento())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado"));

        inscricao.setNomeParticipante(dto.nomeParticipante());
        inscricao.setEmailParticipante(dto.emailParticipante());
        inscricao.setStatus(dto.status());
        inscricao.setEvento(dto.evento());

        Inscricao atualizada = inscricaoRepository.save(inscricao);

        return converterParaResponse(atualizada);
    }

    public void deletar(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Inscrição não encontrada"));

        inscricaoRepository.deleteById(id);
    }

    public List<InscricaoResponseDTO> listarPorEvento(Long idEvento) {
        return inscricaoRepository.findInscricaoByEvento(idEvento)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private InscricaoResponseDTO converterParaResponse(Inscricao inscricao) {
        return new InscricaoResponseDTO(
                inscricao.getNomeParticipante(),
                inscricao.getEmailParticipante(),
                inscricao.getStatus(),
                inscricao.getEvento()
        );
    }
}