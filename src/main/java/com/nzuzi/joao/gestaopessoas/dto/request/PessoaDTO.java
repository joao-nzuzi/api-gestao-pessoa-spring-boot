package com.nzuzi.joao.gestaopessoas.dto.request;

import com.nzuzi.joao.gestaopessoas.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty @Size(min = 2, max = 15)
    private String primeiroNome;

    @NotEmpty @Size(min = 2, max = 15)
    private String ultimoNome;

    @NotEmpty @Size(min = 14, max = 14)
    private String numeroBilhete;

    private String dataNascimento;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;
}
