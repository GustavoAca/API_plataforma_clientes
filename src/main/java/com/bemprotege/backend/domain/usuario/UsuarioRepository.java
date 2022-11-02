package com.bemprotege.backend.domain.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.domain.usuario.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public Optional<UsuarioModel> findByUsuario(String usuario);
}
