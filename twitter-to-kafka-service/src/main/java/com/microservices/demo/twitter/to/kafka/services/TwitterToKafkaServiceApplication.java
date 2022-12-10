package com.microservices.demo.twitter.to.kafka.services;

import com.microservices.demo.twitter.to.kafka.services.init.StreamInitializer;
import com.microservices.demo.twitter.to.kafka.services.runner.StreamRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {


    private final StreamRunner streamRunner;
    private final StreamInitializer streamInitializer;


    public TwitterToKafkaServiceApplication(StreamRunner runner, StreamInitializer streamInitializer) {
        this.streamRunner = runner;
        this.streamInitializer = streamInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts...");
        streamInitializer.init();
        streamRunner.start();
    }
}
