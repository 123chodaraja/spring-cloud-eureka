package com.wipro.greetingclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class GreetingClientApplication {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/call/{name}")
	public String invokePaymentService(@PathVariable String name) {
		String url = "http://EUREKA-DISCOVERY/greeting-service/greet/"+name;
		return restTemplate.getForObject(url, String.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
	}

}
