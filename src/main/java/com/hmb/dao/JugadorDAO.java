package com.hmb.dao;

import com.hmb.config.DatabaseConfig;
import com.hmb.models.Jugador;
import java.sql.*;
//DAO tabla jugadores
public class JugadorDAO {

    //Metodo para registrar un nuevo jugador
    public boolean registrarJugador(String usuario, String contrasena) {
        String sql = "INSERT INTO jugadores (usuario, contrasena) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Metodo para validar login
    public Jugador login(String usuario, String contrasena) {
        String sql = "SELECT * FROM jugadores WHERE usuario = ? AND contrasena = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Jugador(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //Si no coincide el usuario o contraseña, regresa null
    }
}