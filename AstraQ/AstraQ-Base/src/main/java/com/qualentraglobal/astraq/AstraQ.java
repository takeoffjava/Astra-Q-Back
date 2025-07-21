package com.qualentraglobal.astraq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages={
		"com.qualentraglobal.*"})
@EnableJpaRepositories(basePackages = "com.qualentraglobal.astraq.repositories")
@EntityScan(basePackages = "com.qualentraglobal.astraq.entities")
public class AstraQ {
    public static void main(String[] args) {
        SpringApplication.run(AstraQ.class, args);
    }
}