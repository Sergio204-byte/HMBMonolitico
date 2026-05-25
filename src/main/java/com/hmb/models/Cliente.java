package com.hmb.models;
//Modelo para tabla jugadores
public class Cliente{
    private int id;
    private String usuario;
    private String contrasena;

    //Constructor vacío 
    public Cliente() {}

    //Constructor completo
    public Cliente(int id, String usuario, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}