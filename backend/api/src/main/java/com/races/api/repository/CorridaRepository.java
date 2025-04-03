package com.races.api.repository;

import com.races.api.model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {
}