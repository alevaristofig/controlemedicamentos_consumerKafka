package com.controlemedicamentos.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class AplicacaoDTO {

	private Long id;
	
	private PacienteIdDTO paciente;
	
	private MedicamentoIdDTO medicamento;
}
