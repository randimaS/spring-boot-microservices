package com.randi.ordermanagereventuatelocal.aggregate;

import lombok.extern.slf4j.Slf4j;


import com.randi.ordermanagereventuatelocal.command.InitiateOrderCommand;
import com.randi.ordermanagereventuatelocal.command.OrderCommand;
import com.randi.ordermanagereventuatelocal.command.SubmitOrderCommand;
import com.randi.ordermanagereventuatelocal.event.OrderInitiatedEvent;
import com.randi.ordermanagereventuatelocal.event.OrderSubmittedEvent;
import com.randi.ordermanagereventuatelocal.model.Product;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

@Slf4j
public class OrderAggregate extends ReflectiveMutableCommandProcessingAggregate<OrderAggregate, OrderCommand> {

    private String customerAggregateId;
    private boolean orderStatus;
    private Product orderProduct;

    public List<Event> process(InitiateOrderCommand command){
        return EventUtil.events(new OrderInitiatedEvent(command.getCustomerAggregateId(),
                command.getOrderProduct()));
    }

    public List<Event> process (SubmitOrderCommand command){
        return EventUtil.events(new OrderSubmittedEvent(command.isOrderStatus()));
    }

    public void apply(OrderInitiatedEvent event){
        customerAggregateId = event.getCustomerAggregateId();
        orderProduct = event.getOrderProduct();
    }

    public void apply(OrderSubmittedEvent event){
       orderStatus = event.isOrderStatus();
    }
}
