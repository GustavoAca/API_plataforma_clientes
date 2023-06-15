package com.bemprotege.backend.service;

import com.bemprotege.backend.dto.cliente.ClienteDto;
import com.bemprotege.backend.dto.cliente.ClienteMapper;
import com.bemprotege.backend.exception.NaoEncontradoException;
import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ResponseEntity<ClienteDto> buscarPorId(Long id){
        return clienteRepository.findById(id).map(clienteMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<ClienteDto>> encontrarPorNome(String nome){
     return ResponseEntity.ok(clienteRepository.findAllByNomeContainingIgnoreCase(nome)
             .stream().map(clienteMapper::toDto).toList());
    }

    public ResponseEntity<List<ClienteDto>> todos(){
        return ResponseEntity.ok(clienteRepository.findAll().stream().map(clienteMapper::toDto).toList());
    }

    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

    public ResponseEntity<ClienteDto> adicionar(Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteMapper.toDto(clienteRepository.save(cliente)));
    }

    public ResponseEntity<ClienteDto> atualizar(Cliente cliente) throws NaoEncontradoException {
        try{
            return ResponseEntity.ok(clienteMapper.toDto(cliente));
        }catch (Exception e){
            throw new NaoEncontradoException("Cliente não encontrado");
        }
    }
}
