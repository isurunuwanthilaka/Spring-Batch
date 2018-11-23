package com.millenniumit.cdraggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CdrAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdrAggregationApplication.class, args);
    }
}
