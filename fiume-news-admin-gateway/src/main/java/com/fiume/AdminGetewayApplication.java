package com.fiume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminGetewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminGetewayApplication.class, args);
    }
}
