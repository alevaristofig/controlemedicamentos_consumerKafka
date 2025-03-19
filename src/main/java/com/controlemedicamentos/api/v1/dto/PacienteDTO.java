package com.controlemedicamentos.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class PacienteDTO {

	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String raca;
	
	@NotNull
	private Double peso;
	
	@NotBlank
	private String cor;
	
	@NotNull
	private Integer idade;
	
	@NotNull
	private UsuarioIdDTO usuario;
}
