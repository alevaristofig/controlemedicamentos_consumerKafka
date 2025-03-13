package com.controlemedicamentos.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.domain.model.Paciente;

@Component
public class PacienteInputDisassembler {

	@Autowired
	private ModelMapper mapper;
	
	public Paciente toDomainObject(PacienteDTO pacienteDTO) {
		return mapper.map(pacienteDTO, Paciente.class);
	}
}
