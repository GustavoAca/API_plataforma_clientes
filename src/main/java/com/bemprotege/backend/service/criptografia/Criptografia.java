package com.bemprotege.backend.service.criptografia;

import com.bemprotege.backend.model.UsuarioLogin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public interface Criptografia {

    static String criptografarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }

    Optional<UsuarioLogin> autenticaUsuario();

}
