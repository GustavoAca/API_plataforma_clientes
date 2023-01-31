package com.bemprotege.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UsuarioLogin {

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
		
		private String token;
		
		}
