package com.bemprotege.backend.controller;

import java.util.List;

import com.bemprotege.backend.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bemprotege.backend.model.ClienteModel;
import com.bemprotege.backend.repository.ClienteRepository;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

		private ClienteRepository repository;
		private CatalogoClienteService catalogoClienteService;
		
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
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ClienteModel adicionar( @Valid @RequestBody ClienteModel cliente){
			return catalogoClienteService.salvar(cliente);

		}

		@PutMapping("/{clienteId}")
		public ResponseEntity<ClienteModel> atualizar(@Valid @PathVariable Long clienteId,
		@RequestBody ClienteModel cliente){
			if(!repository.existsById(clienteId)){
				return ResponseEntity.notFound().build();
			}

			cliente.setId_cliente(clienteId);
			cliente = catalogoClienteService.salvar(cliente);

			return  ResponseEntity.ok(cliente);

		}
		
		@DeleteMapping("/{id_cliente}")
		public ResponseEntity<Void> deleter(@PathVariable Long id_cliente){
			if(!repository.existsById(id_cliente)){
				return ResponseEntity.notFound().build();
			}
			catalogoClienteService.excluir(id_cliente);

			return ResponseEntity.noContent().build();
		}
		
		
}
