package com.example.apigatewaytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.example.*"})
public class ApiGatewayTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayTestApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(rt -> rt.path("/monitor/**").uri("http://127.0.0.1:8445"))
                .route(rt -> rt.path("/hello").uri("http://127.0.0.1:8445"))
                .route(rt -> rt.path("/dv/**").uri("http://127.0.0.1:8444"))
                .route(rt -> rt.path("/d/**").uri("http://127.0.0.1:8444"))
                .route(rt -> rt.path("/**").uri("http://127.0.0.1:8444"))
                .build();
    }

}

