//package com.example.pmTrial.engine;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
////public class Consumer {
////
////	private final Logger log= LogManager.getLogger(this.getClass());
////	
////	
////	 @KafkaListener(topics = "loginInfo", groupId = "myConsumerGroup")
////	    public void consume(String message) throws IOException {
////	        log.info(String.format("#### -> Consumed message -> %s", message));
////	    }
////	}
//
//public class Consumer {
//
//	static Logger log= LogManager.getLogger(Consumer.class);
//    public static void main(String[] args) {
//        Properties properties = new Properties();
//        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("value.deserializer", "org.springframework.kafka.support.serializer.JsonDeserializer");
//        properties.put("group.id", "myConsumerGroup");
//
//      //creating consumer  
//        KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(properties);  
//        //Subscribing  
//                consumer.subscribe(Arrays.asList("loginInfo"));  
//        //polling  
//        while(true){  
//            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));  
//            for(ConsumerRecord<String,String> record: records){  
//                log.info("Key: "+ record.key() + ", Value:" +record.value());  
//                log.info("Partition:" + record.partition()+",Offset:"+record.offset());  
//            }  
//  
//  
//        }  
//    }  
//}  
//
//
