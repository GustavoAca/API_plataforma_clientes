package com.bemprotege.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.model.VeiculoModel;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
	public List<VeiculoModel> findAllByNomeContainingIgnoreCase(String nome);
}
