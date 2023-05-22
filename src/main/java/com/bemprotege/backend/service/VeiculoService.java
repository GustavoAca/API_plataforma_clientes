package com.bemprotege.backend.service;

import com.bemprotege.backend.model.VeiculoModel;
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

    public ResponseEntity<List<VeiculoModel>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<VeiculoModel> getById(Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<VeiculoModel>> getByTitulo(String nome){
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    public ResponseEntity<VeiculoModel> salvar(VeiculoModel veiculoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(veiculoModel));
    }

    public ResponseEntity<VeiculoModel> alterar(VeiculoModel veiculoModel){
        return repository.findById(veiculoModel.getId())
                .map(resp -> ResponseEntity.ok().body(repository.save(veiculoModel)))
                .orElse(ResponseEntity.notFound().build());
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }



}
