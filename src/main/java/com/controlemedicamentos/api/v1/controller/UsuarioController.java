package com.controlemedicamentos.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.assembler.UsuarioInputDisassembler;
import com.controlemedicamentos.api.v1.assembler.UsuarioModelAssembler;
import com.controlemedicamentos.api.v1.dto.UsuarioDTO;
import com.controlemedicamentos.domain.model.Usuario;
import com.controlemedicamentos.domain.service.UsuarioService;

@RestController
@RequestMapping(path = "/v1/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioInputDisassembler usuarioInputDisassembler;
	
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;

	@GetMapping
	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = service.listar();
		
		return usuarioModelAssembler.toCollectionModel(usuarios);
	}
	
	@GetMapping("/{usuarioId}")
	public UsuarioDTO buscar(@PathVariable("usuarioId") Long usuarioId) {
		Usuario usuario = service.buscarOuFalhar(usuarioId);
		
		return usuarioModelAssembler.toModel(usuario);
	}
	
	@PutMapping("/{id}")
	public UsuarioDTO atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = service.buscarOuFalhar(id);
		
		usuarioDTO.setId(usuario.getId());
		
		usuarioInputDisassembler.toCopyDomain(usuarioDTO, usuario);
		
		usuario = service.atualizar(usuario);
		
		return usuarioModelAssembler.toModel(usuario);		
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable("id") Long id) {
		Usuario usuario = service.buscarOuFalhar(id);
		
		service.remover(usuario);
	}
}
