package br.com.delivery.control;

import br.com.delivery.dao.ClienteDAO;
import br.com.delivery.dao.DroneDAO;
import br.com.delivery.dao.EntregaDAO;
import br.com.delivery.model.Cliente;
import br.com.delivery.model.Drone;
import br.com.delivery.model.Entrega;

public class SistemaControle {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private DroneDAO droneDAO = new DroneDAO();
    private EntregaDAO entregaDAO = new EntregaDAO();

    public void cadastrarCliente(String nome, String email, String senha, String endereco) {
        try {
            Cliente novo = new Cliente(nome, email, senha, endereco);
            clienteDAO.salvar(novo);
            System.out.println(">>> Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public void solicitarEntrega(Cliente cliente, String destino, double peso) {
        // Validação de Segurança
        if (peso <= 0) {
            System.out.println("Erro: Peso inválido.");
            return;
        }

        try {
            // Busca Drone 
            Drone drone = droneDAO.buscarDisponivel(peso);
            
            if (drone == null) {
                System.out.println("Erro: Nenhum drone disponível para este peso no momento.");
                return;
            }

            // Cria e Salva Entrega
            Entrega entrega = new Entrega(cliente, drone, destino, peso);
            entregaDAO.registrar(entrega);
            
            System.out.println(">>> Entrega agendada! Drone ID: " + drone.getId() + " atribuído.");

        } catch (Exception e) {
            System.out.println("Erro no sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}