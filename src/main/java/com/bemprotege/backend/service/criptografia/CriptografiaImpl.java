package com.bemprotege.backend.service.criptografia;

import com.bemprotege.backend.model.UsuarioLogin;
import com.bemprotege.backend.model.Usuario;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Optional;

@Component
public class CriptografiaImpl implements Criptografia {

    private Optional<Usuario> usuarioExistente;
    private Optional<UsuarioLogin> usuarioLogin;

    public CriptografiaImpl(Optional<Usuario> usuarioExistente, Optional<UsuarioLogin> usuarioLogin) {
        this.usuarioExistente = usuarioExistente;
        this.usuarioLogin = usuarioLogin;
    }

    public Optional<UsuarioLogin> autenticaUsuario() {
        if (usuarioExistente.isPresent()) {
            if (compararSenhas(usuarioLogin.get().getSenha(), usuarioExistente.get().getSenha())) {
                usuarioLogin.get().setId(usuarioExistente.get().getId());
                usuarioLogin.get().setNome(usuarioExistente.get().getNome());
                usuarioLogin.get().setFoto(usuarioExistente.get().getFoto());
                usuarioLogin
                        .get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
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
