package com.oracle.bulldozer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BulldozerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BulldozerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
