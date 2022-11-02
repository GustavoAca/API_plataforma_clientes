package com.bemprotege.backend.domain.veiculo;

import com.bemprotege.backend.domain.imagem.ImagensModel;
import com.bemprotege.backend.domain.imagem.ImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VeiculoMapper {

    private final ImagensRepository imagensRepository;

    public VeiculoMapper(ImagensRepository imagensRepository) {
        this.imagensRepository = imagensRepository;
    }

    public VeiculoDto toVeiculoDto(VeiculoModel veiculoModel){
        return VeiculoDto.builder().id(veiculoModel.getId())
                .nome(veiculoModel.getNome())
                .placa(veiculoModel.getPlaca())
                .uber(veiculoModel.isUber())
                .vencimentoBoleto(veiculoModel.getVencimentoBoleto())
                .mensalidade(veiculoModel.getMensalidade())
                .tiposVeiculos(veiculoModel.getTiposVeiculos())
                .cliente(veiculoModel.getCliente())
                .build();
    }

    public VeiculoModel toVeiculoDto(VeiculoDto veiculoDto){
        return VeiculoModel.builder().id(veiculoDto.getId())
                .nome(veiculoDto.getNome())
                .placa(veiculoDto.getPlaca())
                .uber(veiculoDto.isUber())
                .vencimentoBoleto(veiculoDto.getVencimentoBoleto())
                .mensalidade(veiculoDto.getMensalidade())
                .tiposVeiculos(veiculoDto.getTiposVeiculos())
                .cliente(veiculoDto.getCliente())
                .build();
    }


}
