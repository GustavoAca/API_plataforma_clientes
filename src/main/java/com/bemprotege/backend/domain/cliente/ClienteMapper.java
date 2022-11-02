package com.bemprotege.backend.domain.cliente;


import com.bemprotege.backend.domain.veiculo.VeiculoService;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
     private VeiculoService veiculoService;


    public ClienteDto toClienteDto(ClienteModel entity) {
        return ClienteDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .contato(entity.getContato())
                .veiculo(entity.getVeiculo())
                .usuario(entity.getUsuario())
                .build();
    }

    public ClienteModel toClienteEntity(ClienteDto clienteDto) {
        return ClienteModel.builder()
                .id(clienteDto.getId())
                .nome(clienteDto.getNome())
                .contato(clienteDto.getContato())
                .veiculo(clienteDto.getVeiculo())
                .usuario(clienteDto.getUsuario())
                .build();
    }
}
