//package com.example.pmTrial.engine;
//
//import java.util.Properties;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.apache.kafka.common.serialization.LongSerializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AsyncProducerTrial {
//	Logger log= LogManager.getLogger(this.getClass());
//
//	
//	
//	  private final static String TOPIC = "loginInfo";
//	  private final static String key = "Key1";
//	  private final static String value = "${kafka.brokers}";
//	    private final static String BOOTSTRAP_SERVERS =
//	            "localhost:9092";
//
//	
//	private static Producer<String, String> createProducer() {
//      Properties props = new Properties();
//      props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                                          BOOTSTRAP_SERVERS);
//      props.put(ProducerConfig.CLIENT_ID_CONFIG, "AsyncProducerTrial");
//      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                                      StringSerializer.class.getName());
//      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                                  JsonSerializer.class.getName());
//      return new KafkaProducer<>(props);
//  }
//	
//	public void runProducer(final String string) throws InterruptedException {
//	    final Producer<String, String> producer = createProducer();
//	    ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC,key,value);
//
//	      try{
//	           RecordMetadata metadata = producer.send(record).get();
//	           System.out.println("Message is sent to Partition no " + metadata.partition() + " and offset " + metadata.offset());
//	           System.out.println("SynchronousProducer Completed with success.");
//	      }catch (Exception e) {
//	           e.printStackTrace();
//	           System.out.println("SynchronousProducer failed with an exception");
//	      }finally{
//	           producer.close();
//	      }
//	}

//public static void main(String... args) throws Exception {
//		    if (args.length == 0) {
//		        runProducer(5);
//		    } else {
//		        runProducer(Integer.parseInt(args[0]));
//		    }
//		}

//	
//	
//	
//
//}
