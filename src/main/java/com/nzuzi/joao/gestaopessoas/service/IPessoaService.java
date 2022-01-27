package com.nzuzi.joao.gestaopessoas.service;


import com.nzuzi.joao.gestaopessoas.dto.MessageResponseDTO;
import com.nzuzi.joao.gestaopessoas.dto.request.PessoaDTO;
import com.nzuzi.joao.gestaopessoas.entity.Pessoa;

import java.util.List;

public interface IPessoaService {

    MessageResponseDTO cadastrar(PessoaDTO pessoa);
    List<Pessoa> getAll();
}
