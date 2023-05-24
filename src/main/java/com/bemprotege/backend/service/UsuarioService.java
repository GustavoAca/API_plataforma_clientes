package com.bemprotege.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.model.UsuarioLogin;
import com.bemprotege.backend.service.criptografia.Criptografia;
import com.bemprotege.backend.service.criptografia.CriptografiaImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bemprotege.backend.model.Usuario;
import com.bemprotege.backend.repository.UsuarioRepository;

@Service
public class UsuarioService  {

	private final UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Optional<Usuario> cadastraUsuario(Usuario usuario) {

		if (repository.findByUsuario(usuario.getUsuario()).isPresent()) {
			return Optional.empty();
		}
		usuario.setSenha(Criptografia.criptografarSenha(usuario.getSenha()));

		return Optional.of(repository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		if (repository.findById(usuario.getId()).isPresent()) {

			usuario.setSenha(Criptografia.criptografarSenha(usuario.getSenha()));

			return Optional.of(repository.save(usuario));
		}
		return Optional.empty();
	}

	public Optional<Usuario> trazerPorUsuario(String us){
		return repository.findByUsuario(us);
	}

	public ResponseEntity<Optional<UsuarioLogin>> autenticar(Optional<UsuarioLogin> usuarioLogin){
		Optional<Usuario> usuarioEncontrado = repository.findByUsuario(usuarioLogin.get().getUsuario());
		return ResponseEntity.ok(new CriptografiaImpl(usuarioEncontrado,usuarioLogin).autenticaUsuario());
	}
}
