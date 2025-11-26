package br.com.delivery.view;

import br.com.delivery.control.SistemaControle;
import br.com.delivery.model.Cliente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaControle controle = new SistemaControle();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE DRONES 1.0 ===");
        
        // Simulação de Cadastro
        System.out.println("Criando usuário de teste...");
        // Em produção
        controle.cadastrarCliente("João Silva", "joao@email.com", "minhaSenhaForte", "Rua das Flores, 123");
        
        Cliente clienteLogado = new Cliente("João Silva", "joao@email.com", "minhaSenhaForte", "Rua das Flores, 123");

        System.out.println("\n--- Nova Solicitação de Entrega ---");
        System.out.print("Digite o destino: ");
        String destino = scanner.nextLine();
        
        System.out.print("Digite o peso do pacote (kg): ");
        double peso = scanner.nextDouble();
        
        controle.solicitarEntrega(clienteLogado, destino, peso);
        
        scanner.close();
    }
}