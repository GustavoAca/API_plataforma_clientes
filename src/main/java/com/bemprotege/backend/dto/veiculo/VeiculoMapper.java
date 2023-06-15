package com.bemprotege.backend.dto.veiculo;

import com.bemprotege.backend.dto.cliente.ClienteDto;
import com.bemprotege.backend.model.Veiculo;

public class VeiculoMapper {

    public VeiculoDto toDto(Veiculo entity){
       return VeiculoDto.builder().id(entity.getId())
                .nome(entity.getNome())
                .placa(entity.getPlaca())
                .uber(entity.getUber())
                .vencimentoBoleto(entity.getVencimentoBoleto())
                .mensalidade(entity.getMensalidade())
                .tiposVeiculos(entity.getTiposVeiculos())
                .cliente(entity.getCliente()).build();
    }

    public Veiculo toEntity(VeiculoDto dto){
        return Veiculo.builder().id(dto.getId())
                .nome(dto.getNome())
                .placa(dto.getPlaca())
                .uber(dto.getUber())
                .vencimentoBoleto(dto.getVencimentoBoleto())
                .mensalidade(dto.getMensalidade())
                .tiposVeiculos(dto.getTiposVeiculos())
                .cliente(dto.getCliente()).build();
    }

}
