package com.controlemedicamentos.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.domain.model.Aplicacao;

@Component
public class AplicacaoInputDisassembler {

	@Autowired
	private ModelMapper mapper;
	
	public Aplicacao toDomainObject(AplicacaoDTO aplicacaoDTO) {
		return mapper.map(aplicacaoDTO, Aplicacao.class);
	}
}
