package com.controlemedicamentos.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.assembler.AplicacaoModelAssembler;
import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.api.v1.dto.AplicacaoModelDTO;
import com.controlemedicamentos.domain.model.Aplicacao;
import com.controlemedicamentos.domain.service.AplicacaoService;

@RestController
@RequestMapping(path = "/v1/aplicacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class AplicacaoController {

	@Autowired
	private AplicacaoModelAssembler aplicacaoModelAssembler;
	
	@Autowired
	private AplicacaoService service;
	
	@GetMapping
	public List<AplicacaoModelDTO> listar() {
		List<Aplicacao> aplicacoes = service.listar();
		
		return aplicacaoModelAssembler.toCollectionModel(aplicacoes);
	}
}
