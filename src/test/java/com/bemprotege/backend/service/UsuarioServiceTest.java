package com.bemprotege.backend.service;

import com.bemprotege.backend.exception.NaoEncontradoException;
import com.bemprotege.backend.model.Usuario;
import com.bemprotege.backend.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {


    @Autowired
    private UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService = new UsuarioService(usuarioRepository);

    @Nested
    class Dado_uma_usuario{
        @BeforeEach
        void setup(){
            var usuario = Usuario.builder()
                    .nome("Gustavo usuario")
                    .usuario("galasdalas@gmail.com")
                    .id(1L)
                    .senha("12345")
                    .build();
            usuarioService.cadastraUsuario(usuario);
        }

        @Nested
        class Quando_buscar_por_nome{
            Usuario usuario;
            @BeforeEach
            void setup() throws NaoEncontradoException {
                usuario = usuarioService.trazerPorUsuario("Gustavo usuario").orElseThrow(() -> new NaoEncontradoException("Não encontrado"));
            }

            @Test
            void Entao_deve_ter_cadastrado(){
                assertNotNull(usuario);
            }
        }

        @Nested
        class Quando_buscar_por_id{
            Usuario usuario;
            @BeforeEach
            void setup() throws NaoEncontradoException {
                usuario = usuarioService.trazerPorId(1L);
            }

            @Test
            void Entao_deve_ter_cadastrado(){
                assertNotNull(usuario);
            }
        }
    }
}