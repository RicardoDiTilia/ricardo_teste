package com.corridascompartilhadas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity  // Indica que esta classe é uma entidade JPA
public class Motorista {

    @Id  // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremento
    private Long id;

    @Column(nullable = false)  // Campo obrigatório no banco
    private String nome;

    private LocalDate dataNascimento;

    @Column(unique = true, nullable = false)  // CPF único e obrigatório
    private String cpf;

    private String modeloCarro;

    @Enumerated(EnumType.STRING)  // Armazena o valor como String (ex: "ATIVO")
    private StatusMotorista status;  // Enum: ATIVO, INATIVO

    // Getters e Setters (Obrigatórios para o JPA!)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... (gerar automaticamente com Alt+Insert no IntelliJ)
}