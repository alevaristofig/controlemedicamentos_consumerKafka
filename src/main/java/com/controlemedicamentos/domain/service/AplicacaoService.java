package com.controlemedicamentos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlemedicamentos.api.v1.assembler.AplicacaoInputDisassembler;
import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.domain.model.Aplicacao;
import com.controlemedicamentos.domain.repository.AplicacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class AplicacaoService {

	@Autowired
	private AplicacaoInputDisassembler aplicacaoInputDisassembler;
	
	@Autowired
	private AplicacaoRepository repository;
	
	@Transactional
	public void salvarAplicacaoMensagem(AplicacaoDTO aplicacaoDTO) {
		Aplicacao aplicacao = aplicacaoInputDisassembler.toDomainObject(aplicacaoDTO);
		
		repository.save(aplicacao);
	}
}
