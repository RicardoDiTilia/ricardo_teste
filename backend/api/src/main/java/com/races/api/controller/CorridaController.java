package com.races.api.controller;

import com.races.api.model.Corrida;
import com.races.api.model.StatusMotorista;
import com.races.api.repository.CorridaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/corridas")
public class CorridaController {

    private final CorridaRepository repository;

    public CorridaController(CorridaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Corrida>> listar() {
        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Corrida corrida) {
        try {
            if (corrida.getMotorista().getStatus() != StatusMotorista.ATIVO) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Motorista deve estar ativo");
            }

            Corrida salva = repository.save(corrida);
            return ResponseEntity.status(HttpStatus.CREATED).body(salva);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao registrar corrida: " + e.getMessage());
        }
    }
}
