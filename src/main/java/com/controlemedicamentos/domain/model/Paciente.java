package com.controlemedicamentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 255)
	private String nome;
	
	@NotBlank
	@Column(nullable = false, length = 255)
	private String raca;
	
	@NotNull
	@Column(nullable = false)
	private Double peso;
	
	@NotBlank
	@Column(nullable = false, length = 255)
	private String cor;
	
	@NotNull
	@Column(nullable = false)
	private Integer idade;
	
	@JsonIgnore
	@ManyToOne	
	private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE)	
	@JoinColumn(name = "paciente_id")
	private List<Aplicacao> aplicacoes;
	
	@CreationTimestamp
	private LocalDateTime dataCadastro;
	
	@UpdateTimestamp
	private LocalDateTime dataAtualizacao;
}
