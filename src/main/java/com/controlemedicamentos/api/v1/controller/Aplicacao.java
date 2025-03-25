package com.controlemedicamentos.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.assembler.AplicacaoModelAssembler;

@RestController
@RequestMapping(path = "/v1/aplicacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class Aplicacao {

	@Autowired
	private AplicacaoModelAssembler aplicacaoModelAssembler;
}
