package com.randi.ordermanagereventuatelocal.aggregate;

import com.randi.ordermanagereventuatelocal.command.CreateCustomerCommand;
import com.randi.ordermanagereventuatelocal.command.CreateOrderCommand;
import com.randi.ordermanagereventuatelocal.command.CustomerCommand;
import com.randi.ordermanagereventuatelocal.event.CustomerCreatedEvent;
import com.randi.ordermanagereventuatelocal.event.OrderCreatedEvent;
import com.randi.ordermanagereventuatelocal.model.Customer;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CustomerAggregate extends ReflectiveMutableCommandProcessingAggregate<CustomerAggregate, CustomerCommand> {

    private Customer customer;
    private String firstName;
    private String lastName;


    public List<Event> process(CreateCustomerCommand command){
        return EventUtil.events(new CustomerCreatedEvent(command.getNic(),
                command.getFirstName(),
                command.getLastName()));
    }

    public List<Event> process(CreateOrderCommand command){
        return EventUtil.events(new OrderCreatedEvent(command.getOrderAggregateId()));
    }

    public void apply(CustomerCreatedEvent event){
        customer = new Customer();
        customer.setNic(event.getNic());
        firstName = event.getFirstName();
        lastName = event.getLastName();
    }

    public void apply(OrderCreatedEvent event){
        if(customer.getOrderAggregateId()!=null){
            log.warn(
                    "Customer already has an order with [{}]. But an order with aggregate ID [{}] is requested",
                    customer.getOrderAggregateId(),
                    event.getOrderAggregateId()
            );
        }
    }
}
