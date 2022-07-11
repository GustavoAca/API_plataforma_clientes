package com.bemprotege.backend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "veiculos")
public class VeiculoModel {

    // construtores


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

    // relacionamentos

    @ManyToOne
    @JsonIgnoreProperties("veiculo")
    private TiposVeiculosModel tiposVeiculos;

    @OneToMany(mappedBy="veiculo",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("veiculo")
    private ClienteModel cliente;

    // set e get

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TiposVeiculosModel getTiposVeiculos() {
        return tiposVeiculos;
    }

    public void setTiposVeiculos(TiposVeiculosModel tiposVeiculos) {
        this.tiposVeiculos = tiposVeiculos;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public boolean isUber() {
        return uber;
    }

    public void setUber(boolean uber) {
        this.uber = uber;
    }

    public String getVencimentoBoleto() {
        return vencimentoBoleto;
    }

    public void setVencimentoBoleto(String vencimentoBoleto) {
        this.vencimentoBoleto = vencimentoBoleto;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getLinkContrato() {
        return linkContrato;
    }

    public void setLinkContrato(String linkContrato) {
        this.linkContrato = linkContrato;
    }
}
