package com.example.kafkademo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/kafka-test")
public class TestController {


    @Value("${kafka.topic.name}")
    String topicName;

    @Autowired
    KafkaTemplate kafkaTemplate;


    @GetMapping
    String getTopic() {
        kafkaTemplate.send(topicName, "Hello, World!");
        return topicName;
    }

}
