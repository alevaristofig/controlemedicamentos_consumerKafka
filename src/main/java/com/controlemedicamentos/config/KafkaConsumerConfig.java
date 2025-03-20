package com.controlemedicamentos.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.api.v1.dto.UsuarioDTO;

@Configuration
public class KafkaConsumerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value("${topic.usuario-consumer}")
	private String topicUsuarios;
	
	@Value("${topic.paciente-consumer}")
	private String topicPacientes;
	
	@Value("${topic.medicamentos-consumer}")
	private String topicMedicamentos;
	
	@Bean
	public ConsumerFactory<String, UsuarioDTO> usuarioConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, topicUsuarios);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(UsuarioDTO.class,false));
	}
	
	@Bean
	public ConsumerFactory<String, PacienteDTO> pacienteConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, topicPacientes);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(PacienteDTO.class,false));
	}
	
	@Bean
	public ConsumerFactory<String, MedicamentoDTO> medicamentoConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, topicMedicamentos);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(MedicamentoDTO.class,false));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UsuarioDTO> kafkaListenerContainerFactoryUsuario() {
		ConcurrentKafkaListenerContainerFactory<String, UsuarioDTO> factory = new 
				ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(usuarioConsumerFactory());
		
		return factory;
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PacienteDTO> kafkaListenerContainerFactoryPaciente() {
		ConcurrentKafkaListenerContainerFactory<String, PacienteDTO> factory = new 
				ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(pacienteConsumerFactory());
		
		return factory;
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MedicamentoDTO> kafkaListenerContainerFactoryMedicamento() {
		ConcurrentKafkaListenerContainerFactory<String, MedicamentoDTO> factory = new 
				ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(medicamentoConsumerFactory());
		
		return factory;
	}
	
	@Bean
	public StringJsonMessageConverter jsonMessageConverter() {
		return new StringJsonMessageConverter();
	}
}
