package com.corridascompartilhadas.repository;

import com.corridascompartilhadas.model.Motorista;
import com.corridascompartilhadas.model.StatusMotorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    // Busca por CPF (customizada)
    Optional<Motorista> findByCpf(String cpf);

    // Filtro por status (método derivado)
    List<Motorista> findByStatus(StatusMotorista status);

    // Atualização direta de status (query otimizada)
    @Modifying
    @Query("UPDATE Motorista m SET m.status = :status WHERE m.id = :id")
    void atualizarStatus(@Param("id") Long id, @Param("status") StatusMotorista status);

    // Busca por trecho do nome (case insensitive)
    @Query("SELECT m FROM Motorista m WHERE LOWER(m.nome) LIKE LOWER(concat('%', :nome,'%'))")
    List<Motorista> buscarPorNomeSimilar(@Param("nome") String nome);

    // Verifica se existe motorista com o CPF (exceto um ID específico - útil para atualização)
    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Motorista m WHERE m.cpf = :cpf AND m.id <> :id")
    boolean existsByCpfAndIdNot(@Param("cpf") String cpf, @Param("id") Long id);
}