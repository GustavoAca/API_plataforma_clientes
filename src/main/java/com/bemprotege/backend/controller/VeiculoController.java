package com.bemprotege.backend.controller;

import java.util.List;

import com.bemprotege.backend.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("*")
public class VeiculoController {

	private final VeiculoService veiculoService;

	@Autowired
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@GetMapping
	public ResponseEntity<List<VeiculoModel>> getAll(){
		return veiculoService.getAll();
	}

	@GetMapping("/{id_veiculo}")
	public ResponseEntity<VeiculoModel> getById(@PathVariable Long id){
		return veiculoService.getById(id);
	}

	@GetMapping("/titulo/{nome}")
	public ResponseEntity<List<VeiculoModel>> GetByTitulo(@PathVariable String nome){
		return veiculoService.getByTitulo(nome);
	}

	@PostMapping
	public ResponseEntity<VeiculoModel> post(@RequestBody VeiculoModel veiculo){
		return veiculoService.salvar(veiculo);
	}

	@PutMapping
	public ResponseEntity<VeiculoModel> put (@RequestBody VeiculoModel veiculo){
		return veiculoService.alterar(veiculo);
	}

	@DeleteMapping("/{id_veiculo}")
	public void delete(@PathVariable Long id) {
		veiculoService.deletar(id);
	}
}
