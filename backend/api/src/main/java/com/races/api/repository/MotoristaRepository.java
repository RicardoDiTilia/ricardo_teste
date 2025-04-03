package com.races.api.repository;

import com.races.api.model.Motorista;
import com.races.api.model.StatusMotorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    boolean existsByCpf(String cpf);

    Optional<Motorista> findByCpf(String cpf);


    List<Motorista> findByStatus(StatusMotorista status);


    @Modifying
    @Query("UPDATE Motorista m SET m.status = :status WHERE m.id = :id")
    void atualizarStatus(@Param("id") Long id, @Param("status") StatusMotorista status);


    @Query("SELECT m FROM Motorista m WHERE LOWER(m.nome) LIKE LOWER(concat('%', :nome,'%'))")
    List<Motorista> buscarPorNomeSimilar(@Param("nome") String nome);


    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Motorista m WHERE m.cpf = :cpf AND m.id <> :id")
    boolean existsByCpfAndIdNot(@Param("cpf") String cpf, @Param("id") Long id);
}