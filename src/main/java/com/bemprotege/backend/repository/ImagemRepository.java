package com.bemprotege.backend.repository;


import com.bemprotege.backend.model.ImagensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<ImagensModel, Long> {
}
