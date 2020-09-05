package com.poc.useradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = "com.poc.useradmin.repository")
@SpringBootApplication
public class ComPocUseradminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComPocUseradminApplication.class, args);
    }

//    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
