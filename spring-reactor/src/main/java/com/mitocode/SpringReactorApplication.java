package com.mitocode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class SpringReactorApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringReactorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createMono();
	}

	private void createMono() {
		Mono<String> m1 = Mono.just("gente caca");
		m1.subscribe(x -> logger.info(x));
	}
}
