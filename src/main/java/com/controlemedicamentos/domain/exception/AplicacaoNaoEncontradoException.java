package com.controlemedicamentos.domain.exception;

public class AplicacaoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public AplicacaoNaoEncontradoException(String mensagem) {
		super(mensagem);		
	}
	
	public AplicacaoNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de aplicação com o id %d", id));
	}

}
