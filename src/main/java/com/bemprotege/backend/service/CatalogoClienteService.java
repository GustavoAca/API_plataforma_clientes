package com.bemprotege.backend.service;

import com.bemprotege.backend.exception.NegocioException;
import com.bemprotege.backend.model.ClienteModel;
import com.bemprotege.backend.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteModel buscar(Long clienteId){
        return clienteRepository.findById(clienteId).orElseThrow(() -> new NegocioException("Cliente encontrado"));
    }

    @Transactional
    public ClienteModel salvar(ClienteModel cliente){
        boolean nomeEmUso = clienteRepository.findByNome(cliente.getNome())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(nomeEmUso){
            throw new NegocioException("Já existe cliente cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }



}
