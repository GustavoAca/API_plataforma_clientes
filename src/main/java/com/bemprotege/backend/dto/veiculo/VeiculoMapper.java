package com.bemprotege.backend.dto.veiculo;

import com.bemprotege.backend.exception.NaoEncontradoException;
import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.model.Veiculo;
import com.bemprotege.backend.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VeiculoMapper {

    private final ClienteService clienteService;

    public VeiculoMapper(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public VeiculoDto toDto(Veiculo entity){
       return VeiculoDto.builder().id(entity.getId())
                .nome(entity.getNome())
                .placa(entity.getPlaca())
                .uber(entity.getUber())
                .vencimentoBoleto(entity.getVencimentoBoleto())
                .mensalidade(entity.getMensalidade())
                .tiposVeiculos(entity.getTiposVeiculos())
                .cliente(entity.getCliente().getId()).build();
    }

    public Veiculo toEntity(VeiculoDto dto) throws NaoEncontradoException {
        return Veiculo.builder().id(dto.getId())
                .nome(dto.getNome())
                .placa(dto.getPlaca())
                .uber(dto.getUber())
                .vencimentoBoleto(dto.getVencimentoBoleto())
                .mensalidade(dto.getMensalidade())
                .tiposVeiculos(dto.getTiposVeiculos())
                .cliente(getCliente(dto.getCliente()))
                .build();
    }

    private Cliente getCliente(Long id) throws NaoEncontradoException {
        Objects.requireNonNull(id);
       var cliente = clienteService.buscarPorId(id);
        return Cliente.builder()
                .id(cliente.getId())
                .usuario(cliente.getUsuario())
                .contato(cliente.getContato())
                .nome(cliente.getNome())
                .build();
    }

}
