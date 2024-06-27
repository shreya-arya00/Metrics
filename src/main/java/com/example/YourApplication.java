package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.prometheus.client.Counter;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@RestController
public class YourApplication {

    // Example counter metric
    private static final Counter requests = Counter.build()
            .name("requests_total")
            .help("Total requests.")
            .register();

    @GetMapping("/")
    public String home() {
        requests.inc();
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
