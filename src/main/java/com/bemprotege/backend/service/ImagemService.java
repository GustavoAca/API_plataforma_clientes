package com.bemprotege.backend.service;

import com.bemprotege.backend.model.ImagensModel;
import com.bemprotege.backend.repository.ImagemRepository;
import com.bemprotege.backend.repository.VeiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class ImagemService{

    private final ImagemRepository imagemRepository;
    private final String pathArquivos;


    @Autowired
    public ImagemService(ImagemRepository imagemRepository, @Value("${app.path.arquivos}") String pathArquivos) {
        this.imagemRepository = imagemRepository;
        this.pathArquivos = pathArquivos;
    }


    public ResponseEntity<String> salvar(MultipartFile file, Long id){
        ImagensModel imagem = new ImagensModel();
        log.info("Recebendo o arquivo: " + file.getOriginalFilename());
        var caminho = pathArquivos + UUID.randomUUID() + "." + extrairExtensao(
                Objects.requireNonNull(file.getOriginalFilename()));

        log.info("Novo nome do arquivo: " + caminho);

        imagem.setIdVeiculo(id);
        imagem.setUrlImagem(caminho);
        imagemRepository.save(imagem);

        try {
            Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
            return new ResponseEntity<>("{ \"mensagem\": \"Arquivo carregado com sucesso!\"}", HttpStatus.OK);

        } catch (Exception e) {
            log.error("Erro ao processar arquivo", e);
            return new ResponseEntity<>("{ \"mensagem\": \"Erro ao carregar o arquivo!\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String extrairExtensao(String nomeArquivo) {
        int i = nomeArquivo.lastIndexOf(".");
        return nomeArquivo.substring(i + 1);
    }
}
