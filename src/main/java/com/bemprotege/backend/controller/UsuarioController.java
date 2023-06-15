package com.bemprotege.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.repository.ClienteRepository;
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

import com.bemprotege.backend.model.UsuarioLogin;
import com.bemprotege.backend.model.Usuario;
import com.bemprotege.backend.repository.UsuarioRepository;
import com.bemprotege.backend.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
		
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> getAll(){
		return (repository.findAll());
	}
	
	@PostMapping("/logar")
	public ResponseEntity<Optional<UsuarioLogin>> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.autenticar(user);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.cadastraUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.atualizarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@DeleteMapping("/{id_usuario}")
	public void delete(@PathVariable Long id_usuario) {
		repository.deleteById(id_usuario);
	}
}
