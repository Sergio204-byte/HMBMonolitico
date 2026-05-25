package com.hmb.dao;

import com.hmb.config.DatabaseConfig;
import com.hmb.models.Partida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//DAO tabla partidas
public class PartidaDAO {

    //Registra el inicio de una partida nueva
    public boolean insertarPartida(int jugadorId, int intentos) {
        String sql = "INSERT INTO partidas (jugador_id, fecha_ingreso, intentos) VALUES (?, NOW(), ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, jugadorId);
            stmt.setInt(2, intentos);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Obtiene el historial de partidas de un jugador específico
    public List<Partida> obtenerPartidasPorJugador(int jugadorId) {
        List<Partida> lista = new ArrayList<>();
        String sql = "SELECT * FROM partidas WHERE jugador_id = ? ORDER BY fecha_ingreso DESC";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, jugadorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Partida(
                        rs.getInt("id"),
                        rs.getInt("jugador_id"),
                        rs.getTimestamp("fecha_ingreso"),
                        rs.getInt("intentos")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}