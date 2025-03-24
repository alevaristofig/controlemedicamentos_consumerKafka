package com.controlemedicamentos.api.v1.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.domain.service.AplicacaoService;

@EnableKafka
@Component
public class AplicacaoConsumerMessage {

	private static final Logger logger = LoggerFactory.getLogger(AplicacaoConsumerMessage.class);
	
	@Autowired
	private AplicacaoService service;
	
	private final String topic = "aplicacao";
	
	@KafkaListener(topics = topic, groupId = "aplicacao")
	public void listening(AplicacaoDTO aplicacaoDTO) {
		logger.info("Mensagem Aplicacao recebida "+ aplicacaoDTO);
		
		service.salvarAplicacaoMensagem(aplicacaoDTO);
	}
}
