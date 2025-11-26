package br.com.delivery.dao;

import br.com.delivery.model.Entrega;
import br.com.delivery.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {
    
    public void registrar(Entrega entrega) throws SQLException {
        String sql = "INSERT INTO tb_entrega (id_cliente, id_drone, peso, endereco_destino, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Assume que o ID do cliente foi recuperado no login (simulado aqui como 1)
            // Em um sistema real, Cliente teria o ID preenchido vindo do banco
            stmt.setInt(1, 1); // Mock para teste se não tivermos o ID do objeto
            stmt.setInt(2, entrega.getDrone().getId());
            stmt.setDouble(3, entrega.getPeso());
            stmt.setString(4, entrega.getDestino());
            stmt.setString(5, entrega.getStatus());
            
            stmt.execute();
        }
    }
}