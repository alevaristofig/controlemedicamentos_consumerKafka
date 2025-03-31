package com.controlemedicamentos.domain.exception;

public class MedicamentoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public MedicamentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public MedicamentoNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de medicamento com o id %d", id));
	}
}
