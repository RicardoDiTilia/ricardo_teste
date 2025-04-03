package com.races.api.repository;

import com.races.api.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
    Passageiro findByCpf(String cpf); // Método customizado
}