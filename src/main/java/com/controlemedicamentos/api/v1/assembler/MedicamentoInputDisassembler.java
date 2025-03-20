package com.controlemedicamentos.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.domain.model.Medicamento;

@Component
public class MedicamentoInputDisassembler {

	@Autowired
	private ModelMapper mapper;
	
	public Medicamento toDomainObject(MedicamentoDTO medicamentoDTO) {
		return mapper.map(medicamentoDTO, Medicamento.class);
	}
}
