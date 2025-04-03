package com.races.api.controller;

import com.races.api.model.Motorista;
import com.races.api.model.StatusMotorista;
import com.races.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
//import org.springframework.validation.annotation.Validated; nao esta em uso

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @PostMapping
    public ResponseEntity<Motorista> criarMotorista(@Valid @RequestBody Motorista motorista) {
        try {
            if (motoristaRepository.existsByCpf(motorista.getCpf())) {
                throw new IllegalArgumentException("CPF já cadastrado");
            }

            Motorista salvo = motoristaRepository.save(motorista);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Erro ao criar motorista: " + e.getMessage()
            );
        }
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> listarMotoristas() {
        List<Motorista> motoristas = motoristaRepository.findAll();
        return ResponseEntity.ok(motoristas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> buscarPorId(@PathVariable Long id) {
        return motoristaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Motorista> atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return motoristaRepository.findById(id)
                .map(motorista -> {
                    try {
                        StatusMotorista novoStatus = StatusMotorista.valueOf(status.toUpperCase());
                        motorista.setStatus(novoStatus);
                        Motorista atualizado = motoristaRepository.save(motorista);
                        return ResponseEntity.ok(atualizado);
                    } catch (IllegalArgumentException e) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Status inválido. Use: " + Arrays.toString(StatusMotorista.values())
                        );
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        if (!motoristaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        motoristaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/por-status")
    public ResponseEntity<List<Motorista>> listarPorStatus(@RequestParam StatusMotorista status) {
        List<Motorista> motoristas = motoristaRepository.findByStatus(status);
        return ResponseEntity.ok(motoristas);
    }
}