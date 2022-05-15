package com.example.auctionadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class 	AuctionAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionAdminApplication.class, args);
	}

}
