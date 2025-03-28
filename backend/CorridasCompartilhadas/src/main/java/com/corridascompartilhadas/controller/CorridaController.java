package com.corridascompartilhadas.controller;

import com.corridascompartilhadas.model.Corrida;
import com.corridascompartilhadas.repository.CorridaRepository;
import org.springframework.web.bind.annotation.*;
import com.corridascompartilhadas.model.StatusMotorista;

import java.util.List;

@RestController
@RequestMapping("/api/corridas")
public class CorridaController {

    private final CorridaRepository repository;

    public CorridaController(CorridaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Corrida> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Corrida registrar(@RequestBody Corrida corrida) {
        // Validação adicional: motorista deve estar ativo
        if (corrida.getMotorista().getStatus() != StatusMotorista.ATIVO) {
            throw new IllegalArgumentException("Motorista deve estar ativo");
        }
        return repository.save(corrida);
    }
}