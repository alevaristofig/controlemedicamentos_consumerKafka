package com.controlemedicamentos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlemedicamentos.api.v1.assembler.MedicamentoInputDisassembler;
import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.domain.model.Medicamento;
import com.controlemedicamentos.domain.repository.MedicamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository repository;
	
	@Autowired
	private MedicamentoInputDisassembler medicamentoInputDisassembler;
	
	public List<Medicamento> listar() {
		return repository.findAll();
	}
	
	@Transactional
	public void salvarMedicamentoMensagem(MedicamentoDTO medicamentoDTO) {
		Medicamento medicamento = medicamentoInputDisassembler.toDomainObject(medicamentoDTO);
		
		repository.save(medicamento);
	}
}
