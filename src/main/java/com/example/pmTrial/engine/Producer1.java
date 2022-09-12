package com.example.pmTrial.engine;

//import java.util.Properties;

//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public final class Producer1 {
	private static final Logger logger = LogManager.getLogger(Producer1.class);

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String TOPIC = "loginInfo";

	@Autowired
	public Producer1(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendAsync(String message) {
		logger.info(String.format("$$$$ => Producing message asynchronously: %s", message));

		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC, message);
		future.addCallback(new ListenableFutureCallback<>() {
			@Override
			public void onFailure(Throwable ex) {
				logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
			}

			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Sent message asynchronously=[ {} ] with offset=[ {} ] and with timeStamp=[ {} ]", message,
						result.getRecordMetadata().offset(), result.getRecordMetadata().timestamp());
			}
		});
	}
}
