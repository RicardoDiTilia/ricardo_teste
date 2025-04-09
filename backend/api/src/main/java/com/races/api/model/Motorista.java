package com.races.api.model;

import java.time.LocalDate;

public class Motorista {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String modeloCarro;
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
