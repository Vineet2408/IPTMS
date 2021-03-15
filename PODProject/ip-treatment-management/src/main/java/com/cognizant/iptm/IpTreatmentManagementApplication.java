package com.cognizant.iptm;

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
public class IpTreatmentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentManagementApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.iptm")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("IP Treatments API", "Final API for IP Treatments", "1.0.0", "Free to use",
				new springfox.documentation.service.Contact("Jahanvi Gupta", "pod2.com", "jahanvi.gupta@cognizant.com"),
				"API License", "Welcome to IP Treatments API", Collections.emptyList());
	}

}
