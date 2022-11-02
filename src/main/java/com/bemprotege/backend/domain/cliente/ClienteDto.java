package com.bemprotege.backend.domain.cliente;

import com.bemprotege.backend.domain.usuario.UsuarioModel;
import com.bemprotege.backend.domain.veiculo.VeiculoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;

    private String nome;

    private String contato;

    private List<VeiculoModel> veiculo;

    private UsuarioModel usuario;
}
