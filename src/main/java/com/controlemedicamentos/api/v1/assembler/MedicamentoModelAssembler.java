package com.controlemedicamentos.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.domain.model.Medicamento;

@Component
public class MedicamentoModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public MedicamentoDTO toModel(Medicamento medicamento) {
		return mapper.map(medicamento, MedicamentoDTO.class);
	}
	
	public List<MedicamentoDTO> toCollectionModel(List<Medicamento> medicamentos) {
		return medicamentos.stream()
				.map(m -> toModel(m))
				.collect(Collectors.toList());
	}
}
