package com.randi.ordermanagereventuatelocal.service;

import com.randi.ordermanagereventuatelocal.aggregate.OrderAggregate;
import com.randi.ordermanagereventuatelocal.command.InitiateOrderCommand;
import com.randi.ordermanagereventuatelocal.command.OrderCommand;
import com.randi.ordermanagereventuatelocal.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.eventuate.AggregateRepository;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class OrderService {

    private final AggregateRepository<OrderAggregate, OrderCommand> orderAggregateRepository;

    public OrderService(AggregateRepository<OrderAggregate, OrderCommand> orderAggregateRepository){
        this.orderAggregateRepository = orderAggregateRepository;
    }

    public String initiateOrder(String customerAggregateId, Product product) {
        try {
            return orderAggregateRepository.save(new InitiateOrderCommand(customerAggregateId,product)).get().getEntityVersion().asString();
        } catch (InterruptedException | ExecutionException e){
            return e.getMessage();
        }
    }
}
