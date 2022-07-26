package com.bemprotege.backend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "veiculos")
public class VeiculoModel {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veiculo;

    private String nome;

    private String placa;

    private boolean uber;

    private String vencimentoBoleto;

    private float mensalidade;

    private String linkContrato;

    private String observacao;

    private boolean inadiplente;

    // relacionamentos

    @ManyToOne
    @JsonIgnoreProperties("veiculo")
    private TiposVeiculosModel tiposVeiculos;

//    @OneToMany(mappedBy="veiculo", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("veiculo")
//    private List<ClienteModel> cliente;

    @ManyToOne
    @JsonIgnoreProperties("veiculo")
    private ClienteModel cliente;

}
