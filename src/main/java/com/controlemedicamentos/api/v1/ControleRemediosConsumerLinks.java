package com.controlemedicamentos.api.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.controller.AplicacaoController;
import com.controlemedicamentos.api.v1.controller.MedicamentoController;
import com.controlemedicamentos.api.v1.controller.PacienteController;
import com.controlemedicamentos.api.v1.controller.UsuarioController;

@Component
public class ControleRemediosConsumerLinks {
	
	public Link linkToUsuarios(String rel) {
		return linkTo(UsuarioController.class).withRel(rel);
	}
	
	public Link linkToUsuarios() {
		return linkToUsuarios(IanaLinkRelations.SELF.value());
	}

	public Link linkToPacientes(String rel) {
		return linkTo(PacienteController.class).withRel(rel);
	}
	
	public Link linkToPacientes() {
		return linkToPacientes(IanaLinkRelations.SELF.value());
	}
	
	public Link linkToMedicamentos(String rel) {
		return linkTo(MedicamentoController.class).withRel(rel);
	}
	
	public Link linkToMedicamentos() {
		return linkToMedicamentos(IanaLinkRelations.SELF.value());
	}
	
	public Link linkToAplicacao(String rel) {
		return linkTo(AplicacaoController.class).withRel(rel);
	}
	
	public Link linkToAplicacao() {
		return linkToAplicacao(IanaLinkRelations.SELF.value());
	}
}
