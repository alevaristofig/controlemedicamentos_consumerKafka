package com.controlemedicamentos.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.domain.model.Paciente;

@Component
public class PacienteModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public PacienteDTO toModel(Paciente paciente) {
		return mapper.map(paciente, PacienteDTO.class);
	}
	
	public List<PacienteDTO> toCollectionModel(List<Paciente> pacientes) {
		return pacientes.stream()
				.map(p -> toModel(p))
				.collect(Collectors.toList());
	}
}
