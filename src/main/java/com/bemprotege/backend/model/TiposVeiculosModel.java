package com.bemprotege.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipos_veiculos")
public class TiposVeiculosModel {
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipoVeiculo;

	private String tipoVeiculo;

	// RELACIONAMENTO DE TABELAS

	@OneToMany(mappedBy="tiposVeiculos",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tiposVeiculos")
	private List<VeiculoModel> veiculo;
	
	
	// set e get

	public Long getId_tipoVeiculo() {
		return id_tipoVeiculo;
	}

	public void setId_tipoVeiculo(Long id_tipoVeiculo) {
		this.id_tipoVeiculo = id_tipoVeiculo;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public List<VeiculoModel> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<VeiculoModel> veiculo) {
		this.veiculo = veiculo;
	}

}
