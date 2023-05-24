package com.bemprotege.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	List<Veiculo> findAllByNomeContainingIgnoreCase(String nome);
}
