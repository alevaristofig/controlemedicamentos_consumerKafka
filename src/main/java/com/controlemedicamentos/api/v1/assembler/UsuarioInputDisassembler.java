package com.controlemedicamentos.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.UsuarioDTO;
import com.controlemedicamentos.domain.model.Usuario;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper mapper;
	
	public Usuario toDomainObject(UsuarioDTO usuarioDTO) {
		return mapper.map(usuarioDTO, Usuario.class);
	}
	
	public void toCopyDomain(UsuarioDTO usuarioDTO, Usuario usuario) {
		mapper.map(usuarioDTO, usuario);
	}
}
