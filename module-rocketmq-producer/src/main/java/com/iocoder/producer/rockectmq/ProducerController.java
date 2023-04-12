package com.iocoder.producer.rockectmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @RequestMapping("/send")
    public void send(){
        producer.sendMessage("send-out-0","hello rocketmq spring boot message!");
    }

}
