package com.races.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
// import com.races.api.model.StatusMotorista; nao esta em uso

@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private LocalDate dataNascimento;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String modeloCarro;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ATIVO', 'INATIVO')")
    private StatusMotorista status;


    public Motorista() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public StatusMotorista getStatus() {
        return status;
    }

    public void setStatus(StatusMotorista status) {
        this.status = status;
    }
}