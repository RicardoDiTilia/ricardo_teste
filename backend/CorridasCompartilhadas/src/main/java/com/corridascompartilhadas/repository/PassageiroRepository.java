package com.corridascompartilhadas.repository;

import com.corridascompartilhadas.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
    Passageiro findByCpf(String cpf); // Método customizado
}