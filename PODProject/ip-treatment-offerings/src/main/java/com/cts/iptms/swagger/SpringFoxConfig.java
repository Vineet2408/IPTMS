package com.cts.iptms.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.cts.iptms"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiDetails());                                           
    }
    
    private ApiInfo apiDetails() {
    	return new ApiInfo(
    			"IP Treatment Offerings API","Final API for IP Treatment Offerings", "1.0.0", "Free to use",new springfox.documentation.service.Contact("POD - 2 ","abc.com","abc@def.com"), "API License","Welcome to IP Treatment Offerings API",Collections.emptyList());
    }
}
