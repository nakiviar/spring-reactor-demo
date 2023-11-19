package com.mitocode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

//Probando project reactor
@SpringBootApplication
public class SpringReactorApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringReactorApplication.class);
	private List<String> dishes = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(SpringReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dishes.add("Ceviche");
		dishes.add("Carapulcra");
		dishes.add("Estofado de Pollo");
		dishes.add("Causa de Atun");

		//createMono();
		//createFlux();
		//m1doOnNext();
		//m2map();
		m3flatMap();
	}

	private void createFlux() {
		Flux<String> fx1 = Flux.fromIterable(dishes);
		fx1.subscribe(x -> logger.info("Dishes > " + x));
		// Conversion de Flux a Mono > Utilizando el metodo de collectList que devuelve un Mono<List<String>> :
		//fx1.collectList().subscribe(list -> logger.info("Lista > " + list)) ;
	}

	private void createMono() {
		Mono<String> m1 = Mono.just("gente caca");
		m1.subscribe(x -> logger.info(x));
		Mono.just(23).subscribe(x -> logger.info(x.toString()));
	}

	/** Familiarizandonos con la sintaxis **/

	public void m1doOnNext(){
		Flux<String> fx2 = Flux.fromIterable(dishes);
		//metodos de referencia ::
		fx2.doOnNext(logger::info)
				.subscribe();

	}

	public void m2map(){
		Flux<String> fx2 = Flux.fromIterable(dishes);
		// transformando los valores a 1
		fx2.map(x-> 1 )
				.subscribe(x -> logger.info(x.toString()));
		fx2.subscribe(logger::info);
	}

	public void m3flatMap(){
		//flatMap ve el contenido del flujo directamente
		Mono.just("jaime").map(x -> Mono.just(32)).subscribe(e -> logger.info("Data : "+e));
		Mono.just("jaime").flatMap(x -> Mono.just(32)).subscribe(e -> logger.info("Data : "+e));
	}

}
