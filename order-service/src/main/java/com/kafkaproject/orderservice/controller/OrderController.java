package com.kafkaproject.orderservice.controller;

import com.kafkaproject.basedomains.dto.Order;
import com.kafkaproject.basedomains.dto.OrderEvent;
import com.kafkaproject.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    @Autowired
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order pending...");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order places successfully";
    }
}
