package com.cts.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cts.portal")
public class IptmsUIportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(IptmsUIportalApplication.class, args);
	}

}
