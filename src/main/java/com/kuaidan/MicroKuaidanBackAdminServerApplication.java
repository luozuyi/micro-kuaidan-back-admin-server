package com.kuaidan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroKuaidanBackAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroKuaidanBackAdminServerApplication.class, args);
	}

}

