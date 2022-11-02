package com.bemprotege.backend.domain.cliente;

import com.bemprotege.backend.domain.usuario.UsuarioModel;
import com.bemprotege.backend.domain.veiculo.VeiculoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String contato;

	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private List<VeiculoModel> veiculo;

	@ManyToOne
	@JsonIgnoreProperties("cliente")
	private UsuarioModel usuario;

}
