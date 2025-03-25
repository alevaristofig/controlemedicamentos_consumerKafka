package com.controlemedicamentos.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.domain.model.Aplicacao;

@Component
public class AplicacaoModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public AplicacaoDTO toModel(Aplicacao aplicacao) {
		return mapper.map(aplicacao, AplicacaoDTO.class);
	}
	
	public List<AplicacaoDTO> toCollectionModel(List<Aplicacao> aplicacoes) {
		return aplicacoes.stream()
				.map(apl -> toModel(apl))
				.collect(Collectors.toList());
	}
}
