package com.nzuzi.joao.gestaopessoas.service.impl;

import com.nzuzi.joao.gestaopessoas.dto.MessageResponseDTO;
import com.nzuzi.joao.gestaopessoas.entity.Pessoa;
import com.nzuzi.joao.gestaopessoas.repository.PessoaRepo;
import com.nzuzi.joao.gestaopessoas.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements IPessoaService {

    @Autowired
    private PessoaRepo repository;

    @Override
    public MessageResponseDTO cadastrar(Pessoa pessoa) {
        Pessoa pessaoSalva = repository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .mensagem("Cadastro feito com sucesso com")
                .build();
    }
}
