package com.controlemedicamentos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlemedicamentos.api.v1.assembler.PacienteInputDisassembler;
import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.domain.exception.PacienteNaoEncontradoException;
import com.controlemedicamentos.domain.model.Paciente;
import com.controlemedicamentos.domain.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Autowired
	private PacienteInputDisassembler pacienteInputDisassembler;
	
	public List<Paciente> listar() {
		return repository.findAll();
	}
	
	@Transactional
	public void salvarPacienteMensagem(PacienteDTO pacienteDTO) {
		Paciente paciente = pacienteInputDisassembler.toDomainObject(pacienteDTO);
		
		repository.save(paciente);
	}
	
	public Paciente buscarOuFalhar(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new PacienteNaoEncontradoException(id));
	}
}
