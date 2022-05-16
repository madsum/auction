package com.example.auctionserverdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AuctionServerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionServerDiscoveryApplication.class, args);
	}

}
