package com.bemprotege.backend.controller;

import java.util.List;

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

import com.bemprotege.backend.model.TiposVeiculosModel;
import com.bemprotege.backend.repository.TiposVeiculosRepository;

@RestController
@RequestMapping("/tiposVeiculos")
@CrossOrigin("*")
public class TiposVeiculoController {
	
		@Autowired
		private TiposVeiculosRepository repository;
		
		@GetMapping
		public ResponseEntity<List<TiposVeiculosModel>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		

		@GetMapping("/{id_tipoVeiculo}")
		public ResponseEntity<TiposVeiculosModel> getById(@PathVariable Long id_tipoVeiculo){
			return repository.findById(id_tipoVeiculo).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		
		@PostMapping
		public ResponseEntity<TiposVeiculosModel> post(@RequestBody TiposVeiculosModel tipoVeiculo){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipoVeiculo));
		}
		
		@PutMapping
		public ResponseEntity<TiposVeiculosModel> put (@RequestBody TiposVeiculosModel tipoVeiculo){
			return repository.findById(tipoVeiculo.getId_tipoVeiculo())
					.map(resp -> ResponseEntity.ok().body(repository.save(tipoVeiculo)))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/{id_tipoVeiculo}")
		public void delete(@PathVariable Long id_tipoVeiculo) {
				repository.deleteById(id_tipoVeiculo);
		}
		
}
