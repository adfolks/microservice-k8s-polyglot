package com.adfolks.demo.amqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class ActiveMqSubApplication {
	public static void main(String[] args) {
		SpringApplication.run(ActiveMqSubApplication.class, args);
	}

}
