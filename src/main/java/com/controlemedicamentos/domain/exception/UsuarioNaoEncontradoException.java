package com.controlemedicamentos.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);		
	}

	public UsuarioNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de usuário com o id %d", id));	
	}
}
