package com.bemprotege.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bemprotege.backend.model.TiposVeiculosModel;


@Repository
public interface TiposVeiculosRepository extends JpaRepository<TiposVeiculosModel, Long> {
	
}
