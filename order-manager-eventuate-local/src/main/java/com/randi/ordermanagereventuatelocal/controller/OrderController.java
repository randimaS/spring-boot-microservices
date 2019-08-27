package com.randi.ordermanagereventuatelocal.controller;

import com.randi.ordermanagereventuatelocal.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order/init")
    public String initiateOrder( @RequestBody InitiateOrderRequest body){
        log.info("Order initiated with data : [{}]",body);
        return orderService.initiateOrder(body.getCustomerAggregateId(),body.getProduct());
    }
}
