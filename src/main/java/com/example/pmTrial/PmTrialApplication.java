package com.example.pmTrial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableJpaRepositories(basePackages = "com.example.pmTrial.dao")
@SpringBootApplication
public class PmTrialApplication {

	// Logger logger = LoggerFactory.getLogger(PmTrialApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PmTrialApplication.class, args);
	}

}
