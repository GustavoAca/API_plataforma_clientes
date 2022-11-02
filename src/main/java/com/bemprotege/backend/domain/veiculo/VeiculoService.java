package com.bemprotege.backend.domain.veiculo;

import com.bemprotege.backend.domain.imagem.ImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {


    private final VeiculoRepository veiculoRepository;

    private final VeiculoMapper veiculoMapper;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, VeiculoMapper veiculoMapper) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoMapper = veiculoMapper;
    }

    public VeiculoDto salvar(VeiculoModel veiculoModel){
        return veiculoMapper.toVeiculoDto(veiculoRepository.save(veiculoModel));
    }

    public List<VeiculoModel> buscarTodos(){
        return veiculoRepository.findAll();
    }

}
