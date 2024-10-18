package com.example.conversor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/conversor?serverTimezone=Europe/Madrid";
    private static final String USER = "root";  // Tu usuario de MySQL
    private static final String PASSWORD = "root";  // Tu contraseña de MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
