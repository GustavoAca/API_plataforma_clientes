package com.bemprotege.backend.service;

import com.bemprotege.backend.model.VeiculoModel;
import com.bemprotege.backend.repository.ClienteRepository;
import com.bemprotege.backend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VeiculoService {

 private final ClienteRepository clienteRepository;
 private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public List<VeiculoModel> trazerVeiculos(Long id){
        return veiculoRepository.findAll().stream().filter(v -> v.getCliente().getId_cliente().equals(id)).toList();
    }
}
