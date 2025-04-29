package com.controlemedicamentos.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private Integer quantidade;
	
	@NotNull
	private Boolean manipulado;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "medicamento_id")
	private List<Aplicacao> aplicacoes;
	
	@CreationTimestamp
	private LocalDateTime dataCadastro;
	
	@UpdateTimestamp
	private LocalDateTime dataAtualizacao;
}
