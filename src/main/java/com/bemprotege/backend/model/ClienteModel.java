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
	
	private String contato;

	
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

}
