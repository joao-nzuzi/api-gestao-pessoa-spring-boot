package com.nzuzi.joao.gestaopessoas.service;


import com.nzuzi.joao.gestaopessoas.dto.MessageResponseDTO;
import com.nzuzi.joao.gestaopessoas.entity.Pessoa;

public interface IPessoaService {

    MessageResponseDTO cadastrar(Pessoa pessoa);
}
