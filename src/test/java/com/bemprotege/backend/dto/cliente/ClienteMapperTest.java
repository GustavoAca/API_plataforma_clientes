package com.bemprotege.backend.dto.cliente;

import com.bemprotege.backend.exception.NaoEncontradoException;
import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.model.Usuario;
import com.bemprotege.backend.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClienteMapperTest {
    private ClienteMapper clienteMapper = new ClienteMapper();

    @Nested
    class Dado_um_cliente {
        Cliente cliente;

        @BeforeEach
        void setup() {

             var usuario = Usuario.builder()
                    .nome("Gustavo usuario")
                    .usuario("galasdalas@gmail.com")
                    .id(1L)
                    .senha("12345")
                    .build();

            cliente = Cliente.builder().id(1L)
                    .nome("Gustavo")
                    .usuario(usuario)
                    .contato("11995671164")
                    .build();
        }

        @Nested
        class Quando_passar_por_mapper {
            ClienteDto dto;

            @BeforeEach
            void setup() {
                dto = clienteMapper.toDto(cliente);
            }

            @Test
            void Entao_deve_retornar_com_mesmos_atributos() {
                assertNotNull(dto);
                assertEquals("Gustavo", dto.getNome());
                assertEquals("Gustavo usuario", dto.getUsuario().getNome());
                assertEquals("11995671164", dto.getContato());

            }
        }
    }

    @Nested
    class Dado_um_clienteDto {
        ClienteDto clienteDto;

        @BeforeEach
        void setup() {
            clienteDto = ClienteDto.builder().id(1L)
                    .nome("Gustavo")
                    .usuario(Usuario.builder().nome("Gustavo usuario").build())
                    .contato("11995671164")
                    .build();
        }

        @Nested
        class Quando_passar_por_mapper {
            Cliente entity;

            @BeforeEach
            void setup() throws NaoEncontradoException {
                entity = clienteMapper.toEntity(clienteDto);
            }

            @Test
            void Entao_deve_retornar_com_mesmos_atributos() {
                assertNotNull(entity);
                assertEquals("Gustavo", entity.getNome());
                assertEquals("Gustavo usuario", entity.getUsuario().getNome());
                assertEquals("11995671164", entity.getContato());
            }
        }
    }
}
