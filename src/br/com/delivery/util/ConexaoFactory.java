package br.com.delivery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    
    // Configuração para MySQL do XAMPP
    private static final String URL = "jdbc:mysql://localhost:3306/delivery_db?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";       
    private static final String PASS = "";           

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado! Verifique o Build Path.", e);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}