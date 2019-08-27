package com.randi.ordermanagereventuatelocal.service;

import com.randi.ordermanagereventuatelocal.aggregate.CustomerAggregate;
import com.randi.ordermanagereventuatelocal.aggregate.OrderAggregate;
import com.randi.ordermanagereventuatelocal.command.CustomerCommand;
import com.randi.ordermanagereventuatelocal.command.OrderCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BackendConfiguration {

    @Bean
    public AggregateRepository<CustomerAggregate, CustomerCommand> customerAggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(CustomerAggregate.class, eventStore);
    }

    @Bean
    public CustomerService customerService(AggregateRepository<CustomerAggregate,CustomerCommand> customerAggregateRepository){
        return new CustomerService(customerAggregateRepository);
    }

    @Bean
    public AggregateRepository<OrderAggregate,OrderCommand> orderAggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(OrderAggregate.class,eventStore);
    }

    @Bean
    public OrderService orderService(AggregateRepository<OrderAggregate, OrderCommand> orderAggregateRepository){
        return new OrderService(orderAggregateRepository);
    }
}
