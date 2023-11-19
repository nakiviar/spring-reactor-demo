package com.mitocode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        //m3flatMap();
        //m4range();
        //m5delayElements();
        //m6zipWith();
        //m7merge();
        //m8filter();
        //m9takeLast();
        //m10take();
        //m11defaultIfEmpty();
        m12error();
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

    /**
     * Familiarizandonos con la sintaxis
     **/

    public void m1doOnNext() {
        Flux<String> fx2 = Flux.fromIterable(dishes);
        //metodos de referencia ::
        fx2.doOnNext(logger::info)
                .subscribe();

    }

    public void m2map() {
        Flux<String> fx2 = Flux.fromIterable(dishes);
        // transformando los valores a 1
        fx2.map(x -> 1)
                .subscribe(x -> logger.info(x.toString()));
        fx2.subscribe(logger::info);
    }

    public void m3flatMap() {
        //flatMap ve el contenido del flujo directamente
        Mono.just("jaime").map(x -> Mono.just(32)).subscribe(e -> logger.info("Data : " + e));
        Mono.just("jaime").flatMap(x -> Mono.just(32)).subscribe(e -> logger.info("Data : " + e));// el flatMap sirve cuando trabajas con flujos
    }

    public void m4range() {
        Flux<Integer> fx2 = Flux.range(0, 10);
        fx2.map(x -> x + 1)
                .subscribe(x -> logger.info(x.toString()));
    }

    public void m5delayElements() throws InterruptedException {
        //tiempo de espera
        Flux.range(0, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(x -> logger.info(x.toString()))
                .subscribe();

        Thread.sleep(22000);
        //delayElements ejecuta en otros hilos
    }

    private void m6zipWith() {
        List<String> clientes = new ArrayList<>();

        clientes.add("cliente 1");
        clientes.add("cliente 2");
        clientes.add("cliente 3");

        Flux<String> fx1 = Flux.fromIterable(clientes);
        Flux<String> fx2 = Flux.fromIterable(dishes);

        fx1.zipWith(fx2, (c, d) -> c + "-" + d)
                .subscribe(logger::info);

    }

    private void m7merge() {
        List<String> clientes = new ArrayList<>();

        clientes.add("cliente 1");
        clientes.add("cliente 2");
        clientes.add("cliente 3");

        Flux<String> fx1 = Flux.fromIterable(clientes);
        Flux<String> fx2 = Flux.fromIterable(dishes);
        Mono<String> fx3 = Mono.just("Mitocode");

        Flux.merge(fx1, fx2, fx3).subscribe(logger::info);
    }

    private void m8filter() {
        Flux<String> fx2 = Flux.fromIterable(dishes);
        Predicate<String> predicate = x -> x.startsWith("C");
        //fx2.filter(x -> x.startsWith("C")).subscribe(logger::info);
        fx2.filter(predicate).subscribe(logger::info);
    }

    private void m9takeLast() {
        Flux<String> fx1 = Flux.fromIterable(dishes);
        fx1.takeLast(2).subscribe(logger::info); //esta tomando los dos ultimos
    }

    private void m10take() {
        Flux<String> fx1 = Flux.fromIterable(dishes);
        fx1.take(2).subscribe(logger::info); //esta tomando los dos primeros
    }

    private void m11defaultIfEmpty() {
        dishes = new ArrayList<>();
        Flux<String> fx1 = Flux.fromIterable(dishes);
        fx1.map(e -> "dish " + e)
                .defaultIfEmpty("empty :)")
                .subscribe(logger::info);
    }

    private void m12error() {
        Flux<String> fx1 = Flux.fromIterable(dishes);
        fx1.doOnNext(d -> {
                    throw new ArithmeticException("BAD OPERATION");
                })
                .onErrorMap(ex -> new Exception(ex.getMessage()))
                //.onErrorReturn("KKKKKKKKS")
                .subscribe(logger::info);
    }
}
