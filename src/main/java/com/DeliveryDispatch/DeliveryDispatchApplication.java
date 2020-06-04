package com.DeliveryDispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.DeliveryDispatch.Controllers","com.DeliveryDispatch.Boundaries"})
@EntityScan ("com.DeliveryDispatch.Entities")
public class DeliveryDispatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryDispatchApplication.class, args);
	}

}
