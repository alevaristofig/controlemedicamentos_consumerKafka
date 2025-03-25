package com.controlemedicamentos.api.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class AplicacaoModelDTO {

	private Long id;
	
	private AplicacaoPacienteModelDTO paciente;
	
	private AplicacaoMedicamentoModelDTO medicamento;
	
	private LocalDateTime dataAplicacao;
}
