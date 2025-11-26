package br.com.delivery.dao;

import br.com.delivery.model.Cliente;
import br.com.delivery.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    
    // Insere cliente usando PreparedStatement (Segurança SQL Injection)
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO tb_cliente (nome, email, endereco, senha_hash, salt) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getSenhaHash());
            stmt.setString(5, cliente.getSalt());
            
            stmt.execute();
        }
    }
}