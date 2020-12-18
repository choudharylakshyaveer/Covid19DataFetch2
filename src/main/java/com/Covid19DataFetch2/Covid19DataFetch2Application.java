package com.Covid19DataFetch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.Covid19DataFetch2.model.World;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@EnableScheduling
public class Covid19DataFetch2Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19DataFetch2Application.class, args);
	}
}
