package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.dto.LocalEventoRequestDTO;
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

    @Operation(summary = "Busca um local por id")
    @GetMapping("/{idLocal}")
    public LocalEventoResponseDTO buscarPorId(@PathVariable Long idLocal) { return service.buscarPorId(idLocal); }

    @Operation(summary = "Cadastra um novo local")
    @PostMapping
    public LocalEventoResponseDTO cadastrar(@RequestBody @Valid LocalEventoRequestDTO dto) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Atualiza um local existente")
    @PutMapping("/{idLocal}")
    public LocalEventoResponseDTO atualizar(@PathVariable Long idLocal, @RequestBody LocalEventoRequestDTO dto) {
        return service.atualizar(idLocal, dto);
    }

    @Operation(summary = "Remove um local")
    @DeleteMapping("/{idLocal}")
    public void deletar(@PathVariable Long idLocal) {
        service.deletar(idLocal);
    }

    @Operation(summary = "Filtra local por nome")
    @GetMapping("/buscar")
    public List<LocalEventoResponseDTO> filtrarPorNome(@RequestParam String nome) {
        return service.listarPorNome(nome);
    }
}
