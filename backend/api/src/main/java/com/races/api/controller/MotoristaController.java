package com.races.api.controller;

import com.races.api.model.Motorista;
import com.races.api.model.StatusMotorista;
import com.races.api.repository.MotoristaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
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

            Motorista salvo = motoristaRepository.salvar(motorista);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro ao salvar motorista: " + e.getMessage()
            );
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                e.getMessage()
            );
        }
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> listarMotoristas() {
        try {
            List<Motorista> motoristas = motoristaRepository.findAll();
            return ResponseEntity.ok(motoristas);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao listar motoristas", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> buscarPorId(@PathVariable Long id) {
        try {
            return motoristaRepository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar motorista", e);
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Motorista> atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        try {
            StatusMotorista novoStatus = StatusMotorista.valueOf(status.toUpperCase());
            Motorista atualizado = motoristaRepository.atualizarStatus(id, novoStatus);
            if (atualizado != null) {
                return ResponseEntity.ok(atualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Status inválido. Use: " + Arrays.toString(StatusMotorista.values())
            );
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar status", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        try {
            if (!motoristaRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            motoristaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar motorista", e);
        }
    }

    @GetMapping("/por-status")
    public ResponseEntity<List<Motorista>> listarPorStatus(@RequestParam StatusMotorista status) {
        try {
            List<Motorista> motoristas = motoristaRepository.findByStatus(status);
            return ResponseEntity.ok(motoristas);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao filtrar motoristas", e);
        }
    }
}
