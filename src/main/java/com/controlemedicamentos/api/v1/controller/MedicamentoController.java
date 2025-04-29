package com.controlemedicamentos.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.assembler.MedicamentoInputDisassembler;
import com.controlemedicamentos.api.v1.assembler.MedicamentoModelAssembler;
import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.domain.model.Medicamento;
import com.controlemedicamentos.domain.service.MedicamentoService;

@RestController
@RequestMapping(path = "/v1/medicamentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicamentoController {

	@Autowired
	private MedicamentoService service;
	
	@Autowired
	private MedicamentoModelAssembler medicamentoModelAssembler;
	
	@Autowired
	private MedicamentoInputDisassembler medicamentoInputDisassembler;
	
	@GetMapping
	public List<MedicamentoDTO> listar() {
		List<Medicamento> medicamentos = service.listar();
		
		return medicamentoModelAssembler.toCollectionModel(medicamentos);
	}
	
	@GetMapping("/{id}")
	public MedicamentoDTO buscar(@PathVariable("id") Long id) {
		Medicamento medicamento = service.buscarOuFalhar(id);
		
		return medicamentoModelAssembler.toModel(medicamento);
	}
	
	@PutMapping("/{id}")
	public MedicamentoDTO atualizar(@PathVariable("id") Long id, @RequestBody MedicamentoDTO medicamentoDTO) {
		Medicamento medicamento = service.buscarOuFalhar(id);
		
		medicamentoDTO.setId(medicamento.getId());
		
		medicamentoInputDisassembler.toCopyDomain(medicamentoDTO, medicamento);
		
		medicamento = service.atualizar(medicamento);
		
		return medicamentoModelAssembler.toModel(medicamento);
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable("id") Long id) {
		Medicamento medicamento = service.buscarOuFalhar(id);
		
		service.remover(medicamento);
	}
}
