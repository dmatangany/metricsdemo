package com.ayo.demo;

import com.ayo.demo.model.Temperature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import java.io.File;
import java.io.IOException;

@Configuration
@SpringBootApplication
public class SpringRestHttpsClientApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestHttpsClientApp.class, args);
    }

}


