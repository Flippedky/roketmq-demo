package com.luckyi.producer.rockectmq;

import com.luckyi.producer.event.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @Autowired
    EventProducer eventProducer;

    @RequestMapping("/send")
    public void send(){
        producer.sendMessage("send-out-0","hello rocketmq spring boot message!");
    }


    @RequestMapping("/event")
    public void event(){
        eventProducer.publishArticle();
    }


}
