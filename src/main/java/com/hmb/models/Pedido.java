package com.hmb.models;
import java.sql.Timestamp;
//Modelo de tabla partidas
public class Pedido {
    private int id;
    private int jugadorId;
    private Timestamp fechaIngreso;
    private int intentos;
    
    //Constructor vacio
    public Pedido() {}
    //Constructor completo
    public Pedido(int id, int jugadorId, Timestamp fechaIngreso, int intentos) {
        this.id = id;
        this.jugadorId = jugadorId;
        this.fechaIngreso = fechaIngreso;
        this.intentos = intentos;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getJugadorId() { return jugadorId; }
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public Timestamp getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Timestamp fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public int getIntentos() { return intentos; }
    public void setIntentos(int intentos) { this.intentos = intentos; }
}