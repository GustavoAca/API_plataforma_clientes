package com.bemprotege.backend.service;

import com.bemprotege.backend.model.ClienteModel;
import com.bemprotege.backend.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;


}
