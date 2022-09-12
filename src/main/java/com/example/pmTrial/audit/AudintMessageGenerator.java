//package com.example.pmTrial.audit;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//class AudintMessageGenerator {
//	
//	private final Logger log = LogManager.getLogger(this.getClass());
//
//    AtomicInteger count = new AtomicInteger(1);
//	
//	
//	 @Scheduled(fixedDelay = 1000L)
//	    void logSomeStuff() {
//
//	        int index = count.getAndIncrement();
//
//	        // If we exposed log4j2 instead of Slf4j then we could have used ObjectMessage
//	        String jsonString = AuditMessage.builder()
//	                .message("Event Message Generated")
//	                .index(index)
//	                .eventTimestamp(Instant.now())
//	                .build()
//	                .toJSON();
//
//	        // show audit and regular audit based on the presence of Audit Marker
//	        log.info(AuditMarker.getMarker(), jsonString);
//	    }
//	}
//}
