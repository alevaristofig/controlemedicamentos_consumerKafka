package com.controlemedicamentos.api.v1.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.domain.service.PacienteService;

@Component
public class PacienteConsumerMessage {
	
	@Autowired
	private PacienteService service;

	private static final Logger logger = LoggerFactory.getLogger(PacienteConsumerMessage.class);
	
	private final String topic = "pacientes";	
	
	@KafkaListener(topics = topic, groupId = "pacientes")
	public void listeningPacientes(PacienteDTO pacienteDTO) {
		logger.info("Mensagem Paciente Recebida " + pacienteDTO);
				
		service.salvarPacienteMensagem(pacienteDTO);
	}
}
