package com.iocoder.producer;

import com.iocoder.producer.rockectmq.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModuleRocketmqProducerApplicationTests {

	@Autowired
	Producer producer;

	@Test
	void sendMessage() {
		producer.sendMessage("send-out-0","hello rocketmq spring boot message!");
	}

}
