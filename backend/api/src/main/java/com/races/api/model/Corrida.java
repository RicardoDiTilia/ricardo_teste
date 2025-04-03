package com.races.api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Motorista é obrigatório")
    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @NotNull(message = "Passageiro é obrigatório")
    @ManyToOne
    @JoinColumn(name = "passageiro_id", nullable = false)
    private Passageiro passageiro;

    @NotNull(message = "Valor é obrigatório")
    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }
}