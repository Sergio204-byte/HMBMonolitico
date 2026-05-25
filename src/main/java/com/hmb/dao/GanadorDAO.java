package com.hmb.dao;

import com.hmb.config.DatabaseConfig;
import com.hmb.models.Ganador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//DAO tabla ganadores
public class GanadorDAO {

    //Registra un nuevo registro de victoria
    public boolean registrarGanador(int jugadorId) {
        String sql = "INSERT INTO ganadores (jugador_id, fecha_ingreso) VALUES (?, NOW())";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, jugadorId);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Obtiene la lista global de ganadores para mostrar un Top en el JSP
    public List<Ganador> obtenerTodosLosGanadores() {
        List<Ganador> lista = new ArrayList<>();
        String sql = "SELECT * FROM ganadores ORDER BY fecha_ingreso DESC";
        
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                lista.add(new Ganador(
                    rs.getInt("id"),
                    rs.getInt("jugador_id"),
                    rs.getTimestamp("fecha_ingreso")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}