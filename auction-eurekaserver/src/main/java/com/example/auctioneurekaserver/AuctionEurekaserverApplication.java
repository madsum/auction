package com.example.auctioneurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AuctionEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionEurekaserverApplication.class, args);
	}

}
