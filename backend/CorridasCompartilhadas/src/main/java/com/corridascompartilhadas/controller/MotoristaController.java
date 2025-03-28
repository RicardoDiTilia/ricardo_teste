package com.corridascompartilhadas.controller;

import com.corridascompartilhadas.model.Motorista;
import com.corridascompartilhadas.model.StatusMotorista;
import com.corridascompartilhadas.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @PostMapping
    public ResponseEntity<Motorista> criarMotorista(@RequestBody Motorista motorista) {
        try {
            // Validação básica
            if (motorista.getCpf() == null || motorista.getCpf().length() != 11) {
                throw new IllegalArgumentException("CPF deve ter 11 dígitos");
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
    public List<Motorista> listarMotoristas() {
        return motoristaRepository.findAll();
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
                        // Conversão segura para o Enum
                        StatusMotorista novoStatus = StatusMotorista.valueOf(status.toUpperCase());
                        motorista.setStatus(novoStatus);
                        return ResponseEntity.ok(motoristaRepository.save(motorista));
                    } catch (IllegalArgumentException e) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Status inválido. Valores permitidos: " +
                                        Arrays.toString(StatusMotorista.values())
                        );
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        try {
            motoristaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao deletar motorista: " + e.getMessage()
            );
        }
    }

    // Novo endpoint - Listar por status
    @GetMapping("/por-status")
    public List<Motorista> listarPorStatus(@RequestParam StatusMotorista status) {
        return motoristaRepository.findByStatus(status);
    }
}