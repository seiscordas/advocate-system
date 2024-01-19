package com.kl.advocatesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kl.advocatesystem")
public class AdvocateSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvocateSystemApplication.class, args);
    }

}
