package com.bemprotege.backend.service;

import com.bemprotege.backend.model.Veiculo;
import com.bemprotege.backend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    @Autowired
    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Veiculo>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Veiculo> getById(Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Veiculo>> getByTitulo(String nome){
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    public ResponseEntity<Veiculo> salvar(Veiculo veiculoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(veiculoModel));
    }

    public ResponseEntity<Veiculo> alterar(Veiculo veiculoModel){
        return repository.findById(veiculoModel.getId())
                .map(resp -> ResponseEntity.ok().body(repository.save(veiculoModel)))
                .orElse(ResponseEntity.notFound().build());
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }



}
