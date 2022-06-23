package com.bemprotege.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="corretores")
public class ClienteModel {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	
	private String nome;
	
	private float mensalidade;
	
	private String contato;
	
	private boolean uber;
	
	private String vencimentoBoleto;
	
	//RELACIONAMENTO DE TABELAS
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private List<VeiculoModel> veiculo;
	
	@ManyToOne
	@JsonIgnoreProperties("cliente")
	private UsuarioModel usuario;
	
	
	
	//GET E SET

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getContato() {
		return contato;
	}

	public List<VeiculoModel> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<VeiculoModel> veiculo) {
		this.veiculo = veiculo;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public void setContato(String contato) {
		this.contato = contato;
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
	
	
	
}
