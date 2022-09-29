package com.bemprotege.backend.service;

import com.bemprotege.backend.model.ImagensModel;
import com.bemprotege.backend.model.UsuarioModel;
import com.bemprotege.backend.repository.ImagensRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagensService {

    private final ImagensRepository repository;

    @Autowired
    public ImagensService(ImagensRepository imagensRepository) {
        this.repository = imagensRepository;
    }

    public Optional<ImagensModel> salvar (ImagensModel imagem) {
        return repository.findByIdImagem(imagem.getIdImagem()).isPresent() ? Optional.empty() : Optional.of(repository.save(imagem));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
