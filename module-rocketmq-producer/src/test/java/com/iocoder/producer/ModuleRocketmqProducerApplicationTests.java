package com.iocoder.producer;

import com.iocoder.producer.event.EventProducer;
import com.iocoder.producer.rockectmq.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class ModuleRocketmqProducerApplicationTests {

	@Autowired
	Producer producer;

	@Autowired
	EventProducer eventProducer;

	@Test
	void sendMessage() {
		producer.sendMessage("send-out-0","hello rocketmq spring boot message!");
	}

	@Test
	void eventPush(){
		eventProducer.publishArticle();

		eventProducer.userRegister();
	}
}
