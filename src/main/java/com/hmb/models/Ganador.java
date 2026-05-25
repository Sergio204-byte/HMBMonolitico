package com.hmb.models;
import java.sql.Timestamp;
//modelo de tabla ganadores
public class Ganador {
    private int id;
    private int jugadorId;
    private Timestamp fechaIngreso;

    //Constructor vacío 
    public Ganador() {}
    //Constructor completo
    public Ganador(int id, int jugadorId, Timestamp fechaIngreso) {
        this.id = id;
        this.jugadorId = jugadorId;
        this.fechaIngreso = fechaIngreso;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getJugadorId() { return jugadorId; }
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public Timestamp getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Timestamp fechaIngreso) { this.fechaIngreso = fechaIngreso; }
}