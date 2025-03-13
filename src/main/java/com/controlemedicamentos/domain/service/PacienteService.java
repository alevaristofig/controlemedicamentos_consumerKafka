package com.controlemedicamentos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlemedicamentos.api.v1.assembler.PacienteInputDisassembler;
import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.domain.model.Paciente;
import com.controlemedicamentos.domain.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Autowired
	private PacienteInputDisassembler pacienteInputDisassembler;
	
	public void salvarPacienteMensagem(PacienteDTO pacienteDTO) {
		Paciente paciente = pacienteInputDisassembler.toDomainObject(pacienteDTO);
		
		repository.save(paciente);
	}
}
