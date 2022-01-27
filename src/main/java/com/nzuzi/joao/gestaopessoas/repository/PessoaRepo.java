package com.nzuzi.joao.gestaopessoas.repository;

import com.nzuzi.joao.gestaopessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepo extends JpaRepository<Pessoa, Long> {

}
