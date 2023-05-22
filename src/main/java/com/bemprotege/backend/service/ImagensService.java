package com.bemprotege.backend.service;

import com.bemprotege.backend.model.ImagensModel;
import com.bemprotege.backend.model.UsuarioModel;
import com.bemprotege.backend.repository.ImagensRepository;
import lombok.AllArgsConstructor;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
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


    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-fotos}")
    private String diretorioFotos;

    public void salvarFoto(MultipartFile foto) {
        salvar(diretorioFotos, foto);
    }

    public void salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get("/tmp/contato-disco");
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
    }

}
