package br.com.delivery.model;

import java.time.LocalDateTime;

public class Entrega {
    private Cliente cliente;
    private Drone drone;
    private double peso;
    private String destino;
    private String status;
    private LocalDateTime dataSolicitacao;

    public Entrega(Cliente cliente, Drone drone, String destino, double peso) {
        this.cliente = cliente;
        this.drone = drone;
        this.destino = destino;
        this.peso = peso;
        this.status = "SOLICITADA";
        this.dataSolicitacao = LocalDateTime.now();
    }
    
    // Getters
    public Cliente getCliente() { return cliente; }
    public Drone getDrone() { return drone; }
    public double getPeso() { return peso; }
    public String getDestino() { return destino; }
    public String getStatus() { return status; }
}