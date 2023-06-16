package com.bemprotege.backend.controller;

import java.util.List;

import com.bemprotege.backend.dto.cliente.ClienteDto;
import com.bemprotege.backend.exception.NaoEncontradoException;
import com.bemprotege.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll() {
        return clienteService.todos();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClienteDto>> encontrarPorNome(@PathVariable String nome) {
        return clienteService.encontrarPorNome(nome);
    }

    @GetMapping("/{id}")
    public ClienteDto buscaPorId(@PathVariable Long id) throws NaoEncontradoException {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> post(@RequestBody Cliente cliente) {
        return clienteService.adicionar(cliente);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ClienteDto> put(@RequestBody Cliente cliente) throws NaoEncontradoException {
        return clienteService.atualizar(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}
