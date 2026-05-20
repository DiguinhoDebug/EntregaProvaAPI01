package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Eventos", description = "Rotas para gerenciamento de eventos")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @Operation(summary = "Lista todos os eventos")
    @GetMapping
    public List<EventoResponseDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Busca um evento por id")
    @GetMapping("/{idEvento}")
    public EventoResponseDTO buscarPorId(@PathVariable Long idEvento) {
        return service.buscarPorId(idEvento);
    }

    @Operation(summary = "Cadastra um novo evento")
    @PostMapping
    public EventoResponseDTO cadastrar(@RequestBody @Valid EventoRequestDTO dto) {
        //TODO: usar a validação de dados
        return service.cadastrar(dto);
    }

    @Operation(summary = "Atualiza um evento existente")
    @PutMapping("/{idEvento}")
    public EventoResponseDTO atualizar(@PathVariable Long idEvento, @RequestBody EventoRequestDTO dto) {
        return service.atualizar(idEvento, dto);
    }

    @Operation(summary = "Remove um evento")
    @DeleteMapping("/{idEvento}")
    public void deletar(@PathVariable Long idEvento) {
        service.deletar(idEvento);
    }

    @Operation(summary = "Filtra eventos pelo nome")
    @GetMapping("/buscar")
    public List<EventoResponseDTO> filtrarPorNome(@RequestParam String nome) {
        return service.listarPorNome(nome);
    }

    @Operation(summary = "Lista eventos de um determinado local")
    @GetMapping("/local")
    public List<EventoResponseDTO> listarPorLocal(@PathVariable Long idLocal) {
        return service.listarPorLocal(idLocal);
    }
}
