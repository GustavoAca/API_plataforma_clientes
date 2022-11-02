package com.bemprotege.backend.domain.veiculo;

import javax.persistence.*;

import com.bemprotege.backend.domain.cliente.ClienteModel;
import com.bemprotege.backend.domain.imagem.ImagensModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "veiculo")
@NoArgsConstructor
public class VeiculoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String placa;

	private boolean uber;


	@OneToOne
	private ImagensModel imagem;

	private String vencimentoBoleto;

	private BigDecimal mensalidade;

	@Column(name = "tipo_veiculo")
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tiposVeiculos;
	
	@ManyToOne
	@JsonIgnoreProperties("veiculo")
	private ClienteModel cliente;


}
