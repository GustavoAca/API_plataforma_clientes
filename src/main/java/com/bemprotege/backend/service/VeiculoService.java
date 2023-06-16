package com.bemprotege.backend.service;

import com.bemprotege.backend.dto.veiculo.VeiculoDto;
import com.bemprotege.backend.dto.veiculo.VeiculoMapper;
import com.bemprotege.backend.model.Veiculo;
import com.bemprotege.backend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    @Autowired
    public VeiculoService(VeiculoRepository repository,
                          VeiculoMapper veiculoMapper) {
        this.veiculoRepository = repository;
        this.veiculoMapper = veiculoMapper;
    }

    public ResponseEntity<List<VeiculoDto>> getAll(){
        return ResponseEntity.ok(veiculoRepository.findAll().stream().map(veiculoMapper::toDto).toList());
    }

    public ResponseEntity<VeiculoDto> getById(Long id){
        return veiculoRepository.findById(id).map(veiculoMapper::toDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<VeiculoDto>> getByTitulo(String nome){
        return ResponseEntity.ok(veiculoRepository.findAllByNomeContainingIgnoreCase(nome).stream().map(veiculoMapper::toDto).toList());
    }

    public ResponseEntity<VeiculoDto> salvar(Veiculo veiculoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoMapper.toDto(veiculoRepository.save(veiculoModel)));
    }

    public ResponseEntity<VeiculoDto> alterar(Veiculo veiculoModel){
        return veiculoRepository.findById(veiculoModel.getId())
                .map(resp -> ResponseEntity.ok().body(veiculoMapper.toDto(veiculoRepository.save(veiculoModel))))
                .orElse(ResponseEntity.notFound().build());
    }

    public void deletar(Long id){
        veiculoRepository.deleteById(id);
    }

    public ResponseEntity<List<VeiculoDto>> getVeiculosPorVencimento(String vencimento){
        List<VeiculoDto> veiculosPorVencimento = veiculoRepository.findVeiculoByVencimento(vencimento).stream().map(veiculoMapper::toDto).toList();
        return ResponseEntity.ok(veiculosPorVencimento);
    }

}
