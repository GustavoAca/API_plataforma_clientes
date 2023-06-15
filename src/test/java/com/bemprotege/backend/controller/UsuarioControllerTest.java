package com.bemprotege.backend.controller;

import com.bemprotege.backend.model.Usuario;
import com.bemprotege.backend.repository.UsuarioRepository;
import com.bemprotege.backend.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cadastrar() throws Exception {
        var usuario = Usuario.builder()
                .nome("Gustavo usuario")
                .usuario("galasdalas@gmail.com")
                .id(1L)
                .senha("12345")
                .build();

        mockMvc.perform(post("/cadastrar")
                .content(mapper.writeValueAsString(usuario))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}