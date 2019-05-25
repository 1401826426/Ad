package com.fei.adsponsor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.fei.common","com.fei.adsponsor"})
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class AdSponsorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdSponsorApplication.class, args);
    }

}
