package com.bemprotege.backend.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.domain.cliente.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	public List<ClienteModel> findAllByNomeContainingIgnoreCase(String nome);
}
