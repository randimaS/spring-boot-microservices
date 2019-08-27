package com.randi.ordermanagereventuatelocal;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import({EventuateDriverConfiguration.class})
@EnableAutoConfiguration
@ComponentScan({"io.eventuate","com.randi.ordermanagereventuatelocal.controller","com.randi.ordermanagereventuatelocal.service"})
public class OrderManagerEventuateLocalApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerEventuateLocalApplication.class, args);
	}

}
