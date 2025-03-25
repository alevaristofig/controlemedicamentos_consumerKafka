package com.controlemedicamentos.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.api.v1.dto.AplicacaoModelDTO;
import com.controlemedicamentos.domain.model.Aplicacao;

@Component
public class AplicacaoModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public AplicacaoModelDTO toModel(Aplicacao aplicacao) {
		return mapper.map(aplicacao, AplicacaoModelDTO.class);
	}
	
	public List<AplicacaoModelDTO> toCollectionModel(List<Aplicacao> aplicacoes) {
		return aplicacoes.stream()
				.map(apl -> toModel(apl))
				.collect(Collectors.toList());
	}
}
