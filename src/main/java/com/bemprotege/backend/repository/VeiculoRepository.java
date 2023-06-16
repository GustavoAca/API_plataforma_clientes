package com.bemprotege.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	List<Veiculo> findAllByNomeContainingIgnoreCase(String nome);

	@Query(value = "select * from veiculos where vencimento_boleto = ?1", nativeQuery = true)
	List<Veiculo> findVeiculoByVencimento(@Param("vencimento_boleto") String vencimento);
}
