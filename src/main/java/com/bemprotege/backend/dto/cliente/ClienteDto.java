package com.bemprotege.backend.dto.cliente;

import com.bemprotege.backend.model.Cliente;
import com.bemprotege.backend.model.Usuario;
import com.bemprotege.backend.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;
;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor()
@NoArgsConstructor
public class ClienteDto {

    private Long id;
    private String nome;
    private String contato;
    private List<Veiculo> veiculo;
    private Usuario usuario;

}
