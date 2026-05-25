package com.hmb.services;

import com.hmb.dao.JugadorDAO;
import com.hmb.models.Jugador;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class JugadorService {
	
	private JugadorDAO jugadorDAO = new JugadorDAO();
	
	public boolean registrarNuevoJugador(String usuario, String contrasena) {
		
		if(usuario == null || usuario.trim().isEmpty()) {
			System.out.println("No puede ingresar un usuario vacio, lo siento");
			return false;
		}
		
		if(contrasena == null || contrasena.trim().isEmpty()) {
			System.out.println("No puede ingresar una contraseña vacia, lo siento");
			return false;
		}
		
		return jugadorDAO.registrarJugador(usuario, contrasena);
	}
	
	public Jugador iniciarSesion(String usuario, String contrasena) {
		
		if(usuario == null || contrasena == null) {
			return null;
		}
		
		
		Jugador jugadorEncontrado = jugadorDAO.login(usuario, contrasena);

		if (jugadorEncontrado != null) {
			escribirLogAcceso(usuario);
		}
		
		return jugadorEncontrado;
	}
	
	private void escribirLogAcceso(String usuario) {

		System.out.println("LOG DE ACCESO: " + LocalDateTime.now() + " - Usuario: " + usuario + " entró al sistema.");
	
	}
}