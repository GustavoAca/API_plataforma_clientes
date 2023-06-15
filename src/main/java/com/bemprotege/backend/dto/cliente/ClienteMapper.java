package com.bemprotege.backend.dto.cliente;

import com.bemprotege.backend.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDto toDto(Cliente entity){
        return ClienteDto.builder().id(entity.getId())
                .nome(entity.getNome())
                .contato(entity.getContato())
                .veiculo(entity.getVeiculo())
                .usuario(entity.getUsuario())
                .build();
    }

    public Cliente toEntity(ClienteDto dto){
        return Cliente.builder().id(dto.getId())
                .nome(dto.getNome())
                .contato(dto.getContato())
                .veiculo(dto.getVeiculo())
                .usuario(dto.getUsuario())
                .build();
    }
}
