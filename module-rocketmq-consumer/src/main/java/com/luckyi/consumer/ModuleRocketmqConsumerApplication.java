package com.luckyi.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ModuleRocketmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleRocketmqConsumerApplication.class, args);
    }

}
