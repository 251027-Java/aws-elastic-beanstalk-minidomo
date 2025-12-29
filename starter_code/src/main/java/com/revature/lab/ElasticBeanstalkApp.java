package com.revature.lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ElasticBeanstalkApp {

    @Value("${APP_MESSAGE:Hello from Spring Boot!}")
    private String appMessage;

    public static void main(String[] args) {
        SpringApplication.run(ElasticBeanstalkApp.class, args);
    }

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "running");
        response.put("message", appMessage);
        response.put("platform", "AWS Elastic Beanstalk");
        return response;
    }

    @GetMapping("/hello")
    public String hello() {
        return appMessage;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        return response;
    }
}
