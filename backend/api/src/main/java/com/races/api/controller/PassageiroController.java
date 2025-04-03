package com.races.api.controller;

import com.races.api.model.Passageiro;
import com.races.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passageiros")
public class PassageiroController { 

    @Autowired
    private PassageiroRepository repository;

    @GetMapping
    public List<Passageiro> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Passageiro cadastrar(@RequestBody Passageiro passageiro) { 
        return repository.save(passageiro);
    }
}