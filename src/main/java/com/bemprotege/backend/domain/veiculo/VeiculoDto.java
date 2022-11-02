package com.bemprotege.backend.domain.veiculo;

import com.bemprotege.backend.domain.cliente.ClienteModel;
import com.bemprotege.backend.domain.imagem.ImagensModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class VeiculoDto {

    private Long id;

    private String nome;

    private String placa;

    private boolean uber;

    private String vencimentoBoleto;

    private BigDecimal mensalidade;

    private TipoVeiculo tiposVeiculos;

    private ClienteModel cliente;

    private List<ImagensModel> imagem;
}
