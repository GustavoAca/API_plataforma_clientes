package com.bemprotege.backend.dto.veiculo;

import com.bemprotege.backend.dto.cliente.ClienteMapper;
import com.bemprotege.backend.exception.NaoEncontradoException;
import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.model.Veiculo;
import com.bemprotege.backend.model.veiculo.TiposVeiculos;
import com.bemprotege.backend.repository.ClienteRepository;
import com.bemprotege.backend.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoMapperTest {


    private ClienteService clienteService;
    private VeiculoMapper veiculoMapper = new VeiculoMapper(clienteService);

    @Nested
    class Dado_um_veiculo {
        Veiculo veiculo;
        @BeforeEach
        void setup() {
            var cliente = Cliente.builder().id(1L).build();
            veiculo = Veiculo.builder()
                    .id(1L)
                    .nome("Celta")
                    .placa("ABC-1234")
                    .uber(false)
                    .cliente(cliente)
                    .tiposVeiculos(TiposVeiculos.CAMINHAO)
                    .mensalidade(102.2F)
                    .build();
        }

        @Nested
        class Quando_passar_por_mapper {
            VeiculoDto dto;
            @BeforeEach
            void setup() {
                dto = veiculoMapper.toDto(veiculo);
            }

            @Test
            void Entao_deve_ser_iguais() {
                assertNotNull(dto);
                assertEquals("Celta", dto.getNome());
                assertEquals("ABC-1234", dto.getPlaca());
                assertEquals(TiposVeiculos.CAMINHAO, dto.getTiposVeiculos());
            }
        }
    }

    @Nested
    class Dado_um_veiculoDto {
        VeiculoDto dto;
        @BeforeEach
        void setup() {
            var cliente = Cliente.builder().id(1L).build();
            dto = VeiculoDto.builder()
                    .id(1L)
                    .nome("Celta")
                    .placa("ABC-1234")
                    .uber(false)
                    .cliente(1L)
                    .tiposVeiculos(TiposVeiculos.CAMINHAO)
                    .mensalidade(102.2F)
                    .build();

        }

        @Nested
        class Quando_passar_por_mapper {
            Veiculo entity;
            @BeforeEach
            void setup() throws NaoEncontradoException {
                entity = veiculoMapper.toEntity(dto);
            }

            @Test
            void Entao_deve_ser_iguais() {
                assertNotNull(entity);
                assertEquals("Celta", entity.getNome());
                assertEquals("ABC-1234", entity.getPlaca());
                assertEquals(TiposVeiculos.CAMINHAO, entity.getTiposVeiculos());
            }
        }
    }
}