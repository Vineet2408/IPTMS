package com.cts.authorization;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IptmsAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IptmsAuthorizationApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.authorization"))
				.build()
				.apiInfo(apiDetails());   
		
	}
	private ApiInfo apiDetails() {
    	return new ApiInfo(
    			"Authentication API","Final API for Jwt based Authentication ", 
    			"1.0.0", "Free to use",
    			new springfox.documentation.service.Contact("POD - 2 ","abc.com","abc@def.com"), 
    			"API License",
    			"Welcome to Authentication API",
    			Collections.emptyList());
    }
	 

}
