package com.bemprotege.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bemprotege.backend.domain.cliente.ClienteModel;
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

import com.bemprotege.backend.domain.usuario.UsuarioLogin;
import com.bemprotege.backend.domain.usuario.UsuarioModel;
import com.bemprotege.backend.domain.usuario.UsuarioRepository;
import com.bemprotege.backend.domain.usuario.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
		
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{idUsuario}/clientes")
	public ResponseEntity<List<ClienteModel>> getClientes(@PathVariable Long idUsuario){
		return ResponseEntity.ok(usuarioService.trazerClientes(idUsuario));
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.autenticaUsuario(user).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> postUsuario(@Valid @RequestBody UsuarioModel usuario) {

		return usuarioService.cadastraUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModel> putUsuario(@Valid @RequestBody UsuarioModel usuario) {
		return usuarioService.atualizarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@DeleteMapping("/{id_usuario}")
	public void delete(@PathVariable Long id_usuario) {
		repository.deleteById(id_usuario);
	}
}
