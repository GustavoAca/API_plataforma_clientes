package com.bemprotege.backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
		
		//GET E SET

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
}
