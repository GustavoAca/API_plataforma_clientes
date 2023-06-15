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
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name="clientes")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String contato;
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private List<Veiculo> veiculo;
	
	@ManyToOne
	@JsonIgnoreProperties("cliente")
	private Usuario usuario;
}
