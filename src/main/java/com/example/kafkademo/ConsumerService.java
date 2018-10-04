package com.example.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Value("${kafka.topic.name}")
    String topicName;

    @KafkaListener(topics = "${kafka.topic.name}")
    void consume(ConsumerRecord consumerRecord) {
        System.out.println(consumerRecord.value());
    }

}
