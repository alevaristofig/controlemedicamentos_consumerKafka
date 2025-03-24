package com.controlemedicamentos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlemedicamentos.domain.model.Aplicacao;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {

}
