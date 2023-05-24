package com.bemprotege.backend.dto.veiculo;

import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.model.veiculo.TiposVeiculos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDto {

    private Long id;

    private String nome;

    private String placa;

    private Boolean uber;

    private String vencimentoBoleto;

    private Float mensalidade;

    private TiposVeiculos tiposVeiculos;

    private Cliente cliente;
}
