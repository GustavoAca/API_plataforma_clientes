package com.bemprotege.backend.repository;

import com.bemprotege.backend.model.ImagensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagensRepository extends JpaRepository<ImagensModel,Long> {

    Optional<ImagensModel> findByIdImagem(Long idImagem);
}
