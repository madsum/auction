package com.example.auctionbuyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuctionBuyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionBuyerApplication.class, args);
	}

}
