package com.unimall.unimall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "UniMall Project", version = "1.0", description = "UniMall Project"))
public class UnimallApplication {


	
	public static void main(String[] args) {
		
		SpringApplication.run(UnimallApplication.class, args);
		
	}

}
