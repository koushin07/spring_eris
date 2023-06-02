package com.inventory.eris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ErisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErisApplication.class, args);
	}

	@GetMapping("/testing")
	public String testing() {
		return "worksssss!!!!!!!!!!";
	}
}
