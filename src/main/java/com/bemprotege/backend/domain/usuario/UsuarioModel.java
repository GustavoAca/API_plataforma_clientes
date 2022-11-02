package com.bemprotege.backend.domain.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.bemprotege.backend.domain.cliente.ClienteModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Email(message = "O usuário deve ser um email valido ex:maria@email.com")
	private String usuario;

	@Size(min=4, max=100)
	private String senha;

	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<ClienteModel> cliente;


}
