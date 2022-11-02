package com.bemprotege.backend.domain.veiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.domain.veiculo.VeiculoModel;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
	public List<VeiculoModel> findAllByNomeContainingIgnoreCase(String nome);
}
