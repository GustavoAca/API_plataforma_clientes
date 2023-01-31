package com.bemprotege.backend.controller;

import com.bemprotege.backend.service.ImagemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/upload", produces = {"application/json"})
@Slf4j
@CrossOrigin("*")
public class uploadArquivoController {

    private final ImagemService service;

    @Autowired
    public uploadArquivoController(ImagemService service) {
        this.service = service;
    }


    @PostMapping("/{id}/arquivos")
    public ResponseEntity<String> salvarArquivo(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        return  service.salvar(file, id);
    }

}
