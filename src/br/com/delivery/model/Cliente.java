package br.com.delivery.model;

public class Cliente extends Usuario {
    private String endereco;

    public Cliente(String nome, String email, String senha, String endereco) {
        super(nome, email, senha);
        // Validação Fail-Safe no construtor
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço obrigatório.");
        }
        this.endereco = endereco;
    }
    
    // Construtor para leitura do banco
    public Cliente(int id, String nome, String email, String senhaHash, String salt, String endereco) {
        super(id, nome, email, senhaHash, salt);
        this.endereco = endereco;
    }

    public String getEndereco() { return endereco; }
}