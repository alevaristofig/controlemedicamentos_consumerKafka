package com.controlemedicamentos.api.v1.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.domain.service.MedicamentoService;

@EnableKafka
@Component
public class MedicamentoConsumerMessage {

	private final Logger logger = LoggerFactory.getLogger(MedicamentoConsumerMessage.class);
	
	@Autowired
	private MedicamentoService service;
	
	private final String topic = "medicamentos";
	
	@KafkaListener(topics = topic, groupId = topic)
	public void listening(MedicamentoDTO medicamentoDTO) {
		logger.info("Mensagem Medicamento recebida "+ medicamentoDTO);
		
		service.salvarMedicamentoMensagem(medicamentoDTO);
	}
}
