package com.bemprotege.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.awt.*;

@Getter
@Setter
@Entity
@Table(name="imagens")
public class ImagensModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String urlImagem;
    private Long idVeiculo;


}
