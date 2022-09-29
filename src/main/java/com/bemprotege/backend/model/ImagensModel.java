package com.bemprotege.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="imagens")
public class ImagensModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagem;

    private String base64;

    @ManyToOne
    @JsonIgnoreProperties("imagem")
    private VeiculoModel veiculo;

}
