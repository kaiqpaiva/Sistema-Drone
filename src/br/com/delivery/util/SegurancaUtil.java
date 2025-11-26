package br.com.delivery.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SegurancaUtil {
    
    // Gera um 'sal' aleatório para fortalecer a senha
    public static String gerarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Gera o Hash da senha + salt usando SHA-256
    public static String gerarHash(String senha, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(senha.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }
}