package com.corridascompartilhadas.controller;

import com.corridascompartilhadas.model.Passageiro;
import com.corridascompartilhadas.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passageiros")  // Nome corrigido
public class PassageiroController {  // Nome corrigido

    @Autowired
    private PassageiroRepository repository;  // Nome corrigido

    @GetMapping
    public List<Passageiro> listar() {  // Método completo com chaves
        return repository.findAll();  // "findAll" com "L" minúsculo
    }

    @PostMapping
    public Passageiro cadastrar(@RequestBody Passageiro passageiro) {  // Nome corrigido
        return repository.save(passageiro);
    }
}