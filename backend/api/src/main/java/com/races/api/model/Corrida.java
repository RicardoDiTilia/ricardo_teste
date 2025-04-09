package com.races.api.model;

import java.time.LocalDateTime;

public class Corrida {

    private Long id;
    private Motorista motorista;
    private Passageiro passageiro;
    private Double valor;
    private LocalDateTime dataHora = LocalDateTime.now();
    private StatusCorrida status = StatusCorrida.SOLICITADA;

    public Corrida() {}

    public Corrida(Motorista motorista, Passageiro passageiro, Double valor) {
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }
}