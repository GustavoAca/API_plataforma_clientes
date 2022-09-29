package com.bemprotege.backend.controller;

import com.bemprotege.backend.service.ImagensService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/imagens")
@CrossOrigin("*")
public class ImangemController {

    private final ImagensService imagensService;

    @DeleteMapping("/{id_cliente}")
    public void delete(@PathVariable Long id_cliente) {
        imagensService.deletar(id_cliente);
    }
}
