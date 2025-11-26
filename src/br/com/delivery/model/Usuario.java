package br.com.delivery.model;

import br.com.delivery.util.SegurancaUtil;

public abstract class Usuario implements Autenticavel {
    protected int id;
    protected String nome;
    protected String email;
    protected String senhaHash;
    protected String salt;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.salt = SegurancaUtil.gerarSalt(); // Gera salt único
        this.senhaHash = SegurancaUtil.gerarHash(senha, this.salt); // Salva hash
    }
    
    // Construtor para carregar do banco (já tem hash/salt)
    public Usuario(int id, String nome, String email, String senhaHash, String salt) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.salt = salt;
    }

    @Override
    public boolean autenticar(String senhaInput) {
        String novoHash = SegurancaUtil.gerarHash(senhaInput, this.salt);
        return this.senhaHash.equals(novoHash);
    }

    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenhaHash() { return senhaHash; }
    public String getSalt() { return salt; }
    public int getId() { return id; }
}