package com.corridascompartilhadas.repository;

import com.corridascompartilhadas.model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {
}