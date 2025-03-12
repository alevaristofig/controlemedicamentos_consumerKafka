package com.controlemedicamentos.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.UsuarioDTO;
import com.controlemedicamentos.domain.model.Usuario;

@Component
public class UsuarioModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public UsuarioDTO toModel(Usuario usuario) {
		return mapper.map(usuario, UsuarioDTO.class);
	}
	
	public List<UsuarioDTO> toCollectionModel(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(usuario -> toModel(usuario))
				.collect(Collectors.toList());
	}
}
