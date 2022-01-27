package com.nzuzi.joao.gestaopessoas.controller;

import com.nzuzi.joao.gestaopessoas.dto.MessageResponseDTO;
import com.nzuzi.joao.gestaopessoas.entity.Pessoa;
import com.nzuzi.joao.gestaopessoas.repository.PessoaRepo;
import com.nzuzi.joao.gestaopessoas.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl service;

    @PostMapping("/")
    public MessageResponseDTO getPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessaoSalva = service.cadastrar(pessoa);
        return MessageResponseDTO
                .builder()
                .mensagem("Cadastro feito com sucesso com")
                .build();
    }
}
