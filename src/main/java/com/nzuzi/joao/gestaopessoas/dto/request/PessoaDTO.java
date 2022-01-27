package com.nzuzi.joao.gestaopessoas.dto.request;

import com.nzuzi.joao.gestaopessoas.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    private String primeiroNome;

    private String ultimoNome;

    private String numeroBilhete;

    private String dataNascimento;

    private List<Telefone> telefones;
}
