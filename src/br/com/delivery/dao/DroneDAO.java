package br.com.delivery.dao;

import br.com.delivery.model.Drone;
import br.com.delivery.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DroneDAO {
    
    // Busca o primeiro drone que aguenta o peso e tem bateria
    public Drone buscarDisponivel(double peso) throws SQLException {
        String sql = "SELECT * FROM tb_drone WHERE status = 'DISPONIVEL' AND status_bateria > 20 AND capacidade_carga >= ? LIMIT 1";
        
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, peso);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Drone(
                    rs.getInt("id"),
                    rs.getDouble("capacidade_carga"),
                    rs.getInt("status_bateria"),
                    rs.getString("status")
                );
            }
        }
        return null; 
    }
}