package com.randi.ordermanagereventuatelocal.service;

import com.randi.ordermanagereventuatelocal.aggregate.CustomerAggregate;
import com.randi.ordermanagereventuatelocal.command.CreateCustomerCommand;
import com.randi.ordermanagereventuatelocal.command.CustomerCommand;
import io.eventuate.AggregateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Slf4j
@Service
public class CustomerService {
    private final AggregateRepository<CustomerAggregate, CustomerCommand> customerAggregateRepository;

    public CustomerService(AggregateRepository<CustomerAggregate, CustomerCommand> aggregateRepository){
        this.customerAggregateRepository = aggregateRepository;
    }

    public String createCustomer(String nic, String firstName, String lastName) {
        try {
            return customerAggregateRepository.save(new CreateCustomerCommand(nic, firstName, lastName)).get().getEntityVersion().asString();
        } catch (InterruptedException | ExecutionException e){
            return e.getMessage();
        }
    }
}
