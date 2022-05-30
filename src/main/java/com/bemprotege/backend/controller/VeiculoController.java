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

import com.bemprotege.backend.model.VeiculoModel;
import com.bemprotege.backend.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("*")
public class VeiculoController {
		@Autowired
		private VeiculoRepository repository;
		
		@GetMapping
		public ResponseEntity<List<VeiculoModel>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id_veiculo}")
		public ResponseEntity<VeiculoModel> getById(@PathVariable Long id_veiculo){
			return repository.findById(id_veiculo)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/titulo/{nome}")
		public ResponseEntity<List<VeiculoModel>> GetByTitulo(@PathVariable String nome){
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}
		
		@PostMapping
		public ResponseEntity<VeiculoModel> post(@RequestBody VeiculoModel veiculo){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(veiculo));
		}
		
		@PutMapping
		public ResponseEntity<VeiculoModel> put (@RequestBody VeiculoModel veiculo){
			return repository.findById(veiculo.getId_veiculo())
					.map(resp -> ResponseEntity.ok().body(repository.save(veiculo)))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/{id_veiculo}")
		public void delete(@PathVariable Long id_veiculo) {
				repository.deleteById(id_veiculo);
		}
		
		
}
