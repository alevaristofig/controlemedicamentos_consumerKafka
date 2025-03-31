package com.controlemedicamentos.domain.exception;

public class PacienteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public PacienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PacienteNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de paciente com o id %d", id, id));
	}


}
