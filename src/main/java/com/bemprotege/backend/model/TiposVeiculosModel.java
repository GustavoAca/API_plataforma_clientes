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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipos_veiculos")
public class TiposVeiculosModel {
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipoVeiculo;

	private String tipoVeiculo;

	// RELACIONAMENTO DE TABELAS

	@OneToMany(mappedBy = "tiposVeiculos", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tiposVeiculos")
	private List<VeiculoModel> veiculo;


}