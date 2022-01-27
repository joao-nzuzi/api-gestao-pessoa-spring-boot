package com.nzuzi.joao.gestaopessoas.service.impl;

import com.nzuzi.joao.gestaopessoas.dto.MessageResponseDTO;
import com.nzuzi.joao.gestaopessoas.dto.request.PessoaDTO;
import com.nzuzi.joao.gestaopessoas.entity.Pessoa;
import com.nzuzi.joao.gestaopessoas.exception.PessoaNotFoundException;
import com.nzuzi.joao.gestaopessoas.repository.PessoaRepo;
import com.nzuzi.joao.gestaopessoas.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements IPessoaService {

    @Autowired
    private PessoaRepo repository;

    @Override
    public MessageResponseDTO cadastrar(PessoaDTO pessoaDTO) {
        Pessoa pessoaQueSeraSalva = Pessoa.builder()
                .primeiroNome(pessoaDTO.getPrimeiroNome())
                .ultimoNome(pessoaDTO.getUltimoNome())
                .dataNascimento(pessoaDTO.getDataNascimento())
                .telefones(pessoaDTO.getTelefones())
                .numeroBilhete(pessoaDTO.getNumeroBilhete())
                .build();
        Pessoa pessaoSalva = repository.save(pessoaQueSeraSalva);
        return MessageResponseDTO
                .builder()
                .mensagem(pessaoSalva.getPrimeiroNome()+" "+pessaoSalva.getUltimoNome() +" cadastrado com sucesso")
                .build();
    }

    @Override
    public List<Pessoa> getAll() {
        List<Pessoa> pessoas = repository.findAll();

        return pessoas.stream()
                .collect(Collectors.toList());
    }

    public Pessoa getPessoaPorId(Long id) throws PessoaNotFoundException {
        Optional<Pessoa> pessoa = repository.findById(id);
        if(!pessoa.isPresent())
            throw new PessoaNotFoundException(id);
        return pessoa.get();
    }
}
