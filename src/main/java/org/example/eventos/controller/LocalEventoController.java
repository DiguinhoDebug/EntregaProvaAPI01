package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.dto.LocalEventoResponseDTO;
import org.example.eventos.service.InscricaoService;
import org.example.eventos.service.LocalEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Local do Evento", description = "Rotas para gerenciamento do local do evento")
@RestController
@RequestMapping("/localEvento")
public class LocalEventoController {
    @Autowired
    private LocalEventoService service;

    @Operation(summary = "Lista todos os locais")
    @GetMapping
    public List<LocalEventoResponseDTO> listar() { return service.listarTodos(); }

    @Operation(summary = "Busca uma inscrição por id")
    @GetMapping("/{idEvento}")
    public InscricaoResponseDTO buscarPorId(@PathVariable Long idInscricao) {
        return service.buscarPorId(idInscricao);
    }

    @Operation(summary = "Cadastra uma nova inscrição")
    @PostMapping
    public InscricaoResponseDTO cadastrar(@RequestBody @Valid InscricaoRequestDTO dto) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Atualiza uma inscrição existente")
    @PutMapping("/{idInscricao}")
    public InscricaoResponseDTO atualizar(@PathVariable Long idInscricao, @RequestBody InscricaoRequestDTO dto) {
        return service.atualizar(idInscricao, dto);
    }

    @Operation(summary = "Remove uma inscrição")
    @DeleteMapping("/{idInscricao}")
    public void deletar(@PathVariable Long idInscricao) {
        service.deletar(idInscricao);
    }

    @Operation(summary = "Filtra inscrições pelo evento")
    @GetMapping("/buscar")
    public List<InscricaoResponseDTO> filtrarPorEvento(@RequestParam Long idEvento) {
        return service.listarPorEvento(idEvento);
    }
}
