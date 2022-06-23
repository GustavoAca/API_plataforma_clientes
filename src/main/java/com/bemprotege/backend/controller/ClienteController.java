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

import com.bemprotege.backend.model.ClienteModel;
import com.bemprotege.backend.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {
		@Autowired
		private ClienteRepository repository;
		
		@GetMapping
		public ResponseEntity<List<ClienteModel>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<ClienteModel>> encontrarPorNome(@PathVariable String nome){
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}
		
		@GetMapping("/{id_cliente}")
		public ResponseEntity<ClienteModel> buscaPorID(@PathVariable Long id_cliente){
			return repository.findById(id_cliente)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@PostMapping
		public ResponseEntity<ClienteModel> post(@RequestBody ClienteModel cliente){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
		}
		
		@PutMapping
		public ResponseEntity<ClienteModel> put (@RequestBody ClienteModel cliente){
			return repository.findById(cliente.getId_cliente())
					.map(resp -> ResponseEntity.ok().body(repository.save(cliente)))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/{id_cliente}")
		public void delete(@PathVariable Long id_cliente) {
				repository.deleteById(id_cliente);
		}
		
		
}
