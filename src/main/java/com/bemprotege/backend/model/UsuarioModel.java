package com.bemprotege.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
	
	//ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	@Size(min=2, max=100)
	private String nome;

	@NotNull
	@Email(message = "O usuário deve ser um email valido ex:maria@email.com")
	private String usuario;

	@NotNull
	@Size(min=4, max=100)
	private String senha;

	private String foto;
	
	//RELAÇÃO ENTRE TABELAS
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<ClienteModel> cliente;


}
