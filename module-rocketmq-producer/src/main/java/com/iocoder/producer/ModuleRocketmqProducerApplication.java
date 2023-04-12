package com.iocoder.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding
public class ModuleRocketmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleRocketmqProducerApplication.class, args);
	}

}
