package com.bemprotege.backend.repository;

import java.util.List;

import com.bemprotege.backend.dto.cliente.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findAllByNomeContainingIgnoreCase(String nome);

	@Query("select nome from Cliente c where c.usuario_id = ?1")
	List<Cliente> findClientesDeUsuario(Long id);
}
