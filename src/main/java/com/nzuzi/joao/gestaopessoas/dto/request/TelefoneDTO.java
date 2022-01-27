package com.nzuzi.joao.gestaopessoas.dto.request;

import com.nzuzi.joao.gestaopessoas.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;
    private TipoTelefone tipo;
    private String numero;
}
