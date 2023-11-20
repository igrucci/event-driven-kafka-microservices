package com.kafkaproject.emailservice.kafka;

import com.kafkaproject.basedomains.dto.OrderEvent;
import com.kafkaproject.emailservice.service.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private EmailSenderService senderService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    @EventListener(ApplicationReadyEvent.class)
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("order event received in email-> %s", orderEvent.toString()));


        senderService.sendMail("testemail@gmail.com",
                "order",
                orderEvent.toString());
    }

}


