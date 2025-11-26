package br.com.delivery.model;

public class Drone {
    private int id;
    private double capacidadeCarga;
    private int statusBateria;
    private String status;

    public Drone(int id, double capacidadeCarga, int statusBateria, String status) {
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
        this.statusBateria = statusBateria;
        this.status = status;
    }

    public boolean verificarDisponibilidade(double pesoPacote) {
        return this.status.equals("DISPONIVEL") && 
               this.statusBateria > 20 && 
               this.capacidadeCarga >= pesoPacote;
    }
    
    public int getId() { return id; }
}