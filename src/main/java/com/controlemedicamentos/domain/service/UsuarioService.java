package com.controlemedicamentos.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlemedicamentos.api.v1.assembler.UsuarioInputDisassembler;
import com.controlemedicamentos.api.v1.dto.UsuarioDTO;
import com.controlemedicamentos.domain.model.Usuario;
import com.controlemedicamentos.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioInputDisassembler usuarioInputDisassembler;
	
	public void salvarUsuarioMensagem(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioDTO);
		
		repository.save(usuario);				
	}
	
	public List<Usuario> listar() {
		return repository.findAll();
	}
}
