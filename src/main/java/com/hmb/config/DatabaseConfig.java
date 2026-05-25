package com.hmb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    //Nombre de la base de datos en MySQL (Nombre del archivo .sql: HMB)
    private static final String URL = "jdbc:mysql://localhost:3306/HMB"; 
    
    //Credenciales por defecto de MySQL. 
    //MODIFICAR CREDENCIALES SEGÚN CONFIGURACION LOCAL
    private static final String USER = "root"; 
    private static final String PASSWORD = "tu_contraseña_aqui"; 

    public static Connection getConnection() throws SQLException {
        try {
            //Carga el Driver de conexión de MySQL en memoria
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error: Driver MySQL no encontrado en el proyecto.", e);
        }
    }
}