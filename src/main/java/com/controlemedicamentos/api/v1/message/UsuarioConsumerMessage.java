package com.controlemedicamentos.api.v1.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.UsuarioDTO;
import com.controlemedicamentos.domain.service.UsuarioService;

@Component
@EnableKafka
public class UsuarioConsumerMessage {

	private final Logger logger = LoggerFactory.getLogger(UsuarioConsumerMessage.class);
	
	@Autowired
	private UsuarioService service;
	
	private final String topic = "usuarios";
	
	@KafkaListener(topics = topic, groupId = "usuarios")
	public void listening(UsuarioDTO usuarioDTO) {
		logger.info("Mensagem Usuario recebida "+ usuarioDTO);
		
		service.salvarUsuarioMensagem(usuarioDTO);
	}
}
