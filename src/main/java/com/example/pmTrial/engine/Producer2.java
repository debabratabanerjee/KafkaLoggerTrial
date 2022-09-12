package com.example.pmTrial.engine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//This is Synchronous Producer for Kafka using in this project
@Component
public final class Producer2 {
	private static final Logger logger = LogManager.getLogger(Producer2.class);

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String TOPIC = "loginInfo";

	@Autowired
	public Producer2(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendSync(String message) {
		logger.info(String.format("$$$$ => Producing message: %s", message));

		kafkaTemplate.send(TOPIC, message);

	}

}
