package com.bemprotege.backend.service;

import com.bemprotege.backend.model.UsuarioLogin;
import com.bemprotege.backend.model.UsuarioModel;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Optional;

@Component
public class Criptografia {

    private Optional<UsuarioModel> usuarioExistente;
    private Optional<UsuarioLogin> usuarioLogin;

    public Criptografia(Optional<UsuarioModel> usuarioExistente, Optional<UsuarioLogin> usuarioLogin) {
        this.usuarioExistente = usuarioExistente;
        this.usuarioLogin = usuarioLogin;
    }


    public static String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public Optional<UsuarioLogin> autenticaUsuario() {
        if (usuarioExistente.isPresent()) {
            // comparar senha retorna um verdadeiro ou falso
            if (compararSenhas(usuarioLogin.get().getSenha(), usuarioExistente.get().getSenha())) {
                // Se as senhas forem iguais, ele vai preencher os dados de id,nome e foto, e
                // ira gerar um token
                usuarioLogin.get().setId(usuarioExistente.get().getId());
                usuarioLogin.get().setNome(usuarioExistente.get().getNome());
                usuarioLogin.get().setFoto(usuarioExistente.get().getFoto());
                usuarioLogin.get()
                        .setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
                usuarioLogin.get().setSenha(usuarioExistente.get().getSenha());

                return usuarioLogin;
            }
        }

        return Optional.empty();
    }

    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senhaDigitada, senhaBanco);
    }

    private String gerarBasicToken(String usuario, String senha) {

        String token = usuario + ":" + senha;

        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(tokenBase64);
    }
}
