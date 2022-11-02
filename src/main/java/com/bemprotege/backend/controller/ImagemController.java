package com.bemprotege.backend.controller;


import com.bemprotege.backend.domain.imagem.ImagensModel;
import com.bemprotege.backend.domain.imagem.ImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImagemController {

    private final ImagensRepository imagemRepository;

    @Autowired
    public ImagemController(ImagensRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    @GetMapping
    public ResponseEntity<List<ImagensModel>> getAll(){
        return ResponseEntity.ok(imagemRepository.findAll());
    }


}
