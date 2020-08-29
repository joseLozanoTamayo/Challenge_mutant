package org.mutant.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("org.mutant.demo")
@EnableAsync
public class MutantApplication {
	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
	}
}
