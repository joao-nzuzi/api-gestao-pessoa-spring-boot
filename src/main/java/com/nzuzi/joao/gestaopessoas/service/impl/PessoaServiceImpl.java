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
        Pessoa pessaoSalva = salvarPessoa(pessoaDTO);
        return getMessageResponse(pessaoSalva, " cadastrado com sucesso");
    }

    @Override
    public List<Pessoa> getAll() {
        List<Pessoa> pessoas = repository.findAll();

        return pessoas.stream()
                .collect(Collectors.toList());
    }

    @Override
    public Pessoa getPessoaPorId(Long id) throws PessoaNotFoundException {

        /*Alternativa 1
        verificaSePessoaExiste(id);
        */

        //Alternativa 2
        Optional<Pessoa> pessoa = repository.findById(id);
        if(!pessoa.isPresent())
            throw new PessoaNotFoundException(id);
        return pessoa.get();
    }

    @Override
    public void deleteById(Long id) throws PessoaNotFoundException {
        verificaSePessoaExiste(id);
        repository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        verificaSePessoaExiste(id);
        Pessoa pessaoEditada = editarPessoa(pessoaDTO);
        return getMessageResponse(pessaoEditada, " alterada com sucesso");
    }

    private void verificaSePessoaExiste(Long id) throws PessoaNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    private Pessoa salvarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaQueSeraSalva = Pessoa.builder()
                .primeiroNome(pessoaDTO.getPrimeiroNome())
                .ultimoNome(pessoaDTO.getUltimoNome())
                .dataNascimento(pessoaDTO.getDataNascimento())
                .telefones(pessoaDTO.getTelefones())
                .numeroBilhete(pessoaDTO.getNumeroBilhete())
                .build();
        return repository.save(pessoaQueSeraSalva);
    }

    private Pessoa editarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaQueSeraEditada = Pessoa.builder()
                .primeiroNome(pessoaDTO.getPrimeiroNome())
                .ultimoNome(pessoaDTO.getUltimoNome())
                .dataNascimento(pessoaDTO.getDataNascimento())
                .telefones(pessoaDTO.getTelefones())
                .numeroBilhete(pessoaDTO.getNumeroBilhete())
                .build();
        return repository.save(pessoaQueSeraEditada);
    }

    private MessageResponseDTO getMessageResponse(Pessoa pessaoEditada, String mensagem) {
        return MessageResponseDTO
                .builder()
                .mensagem(pessaoEditada.getPrimeiroNome() + " " + pessaoEditada.getUltimoNome() + mensagem)
                .build();
    }
}
