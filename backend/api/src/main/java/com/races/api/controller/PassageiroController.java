package com.races.api.controller;

import com.races.api.model.Passageiro;
import com.races.api.repository.PassageiroRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/passageiros")
public class PassageiroController {

    private final PassageiroRepository repository;

    public PassageiroController(PassageiroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Passageiro> listar() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar passageiros: " + e.getMessage());
        }
    }

    @PostMapping
    public Passageiro cadastrar(@RequestBody Passageiro passageiro) {
        try {
            return repository.save(passageiro);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar passageiro: " + e.getMessage());
        }
    }
}
