package com.bemprotege.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bemprotege.backend.model.ClienteModel;
import com.bemprotege.backend.model.UsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bemprotege.backend.model.UsuarioModel;
import com.bemprotege.backend.repository.UsuarioRepository;

@Service
public class UsuarioService  {


	@Autowired
	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	public Optional<UsuarioModel> cadastraUsuario(UsuarioModel usuario) {

		if (repository.findByUsuario(usuario.getUsuario()).isPresent()) {
			return Optional.empty();
		}

		usuario.setSenha(Criptografia.criptografarSenha(usuario.getSenha()));

		return Optional.of(repository.save(usuario));
	}

	public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuario) {

		if (repository.findById(usuario.getId()).isPresent()) {

			usuario.setSenha(Criptografia.criptografarSenha(usuario.getSenha()));

			return Optional.of(repository.save(usuario));
		}
		return Optional.empty();
	}

	public List<ClienteModel> trazerClientes(Long id){
		Optional<UsuarioModel> usuario = repository.findById(id);
		List<ClienteModel> lista = new ArrayList<>();
			for (int i = 0; i< usuario.get().getCliente().size(); i++){
				lista.add(usuario.get().getCliente().get(i));
			}
			return lista;
	}

	public Optional<UsuarioModel> trazerPorUsuario(String us){
		return repository.findByUsuario(us);
	}

	public Optional<UsuarioLogin> autenticar(Optional<UsuarioLogin> usuarioLogin){
		Optional<UsuarioModel> usuarioEncontrado = repository.findByUsuario(usuarioLogin.get().getUsuario());
		return new Criptografia(usuarioEncontrado,usuarioLogin).autenticaUsuario();
	}
}
