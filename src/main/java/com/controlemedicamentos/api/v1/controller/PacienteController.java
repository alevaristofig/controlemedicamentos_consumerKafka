package com.controlemedicamentos.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.assembler.PacienteModelAssembler;
import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.domain.model.Paciente;
import com.controlemedicamentos.domain.service.PacienteService;

@RestController
@RequestMapping(path = "/v1/pacientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@Autowired
	private PacienteModelAssembler pacienteModelAssembler;

	@GetMapping
	public List<PacienteDTO> listar(){
		List<Paciente> pacientes = service.listar();
		
		return pacienteModelAssembler.toCollectionModel(pacientes);
	}
	
	@GetMapping("/{id}")
	public PacienteDTO buscar(@PathVariable Long id) {
		Paciente paciente = service.buscarOuFalhar(id);
		
		return pacienteModelAssembler.toModel(paciente);
	}
}
