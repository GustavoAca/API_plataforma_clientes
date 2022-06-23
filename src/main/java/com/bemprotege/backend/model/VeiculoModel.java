package com.bemprotege.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	// relacionamentos
	
	@ManyToOne
	@JsonIgnoreProperties("veiculo")
	private TiposVeiculosModel tiposVeiculos;
	
	@ManyToOne
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

	public ClienteModel getCorretor() {
		return cliente;
	}

	public void setCorretor(ClienteModel cliente) {
		this.cliente = cliente;
	}
	
		
}
