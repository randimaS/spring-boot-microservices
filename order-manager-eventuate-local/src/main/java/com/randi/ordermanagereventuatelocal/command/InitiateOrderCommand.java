package com.randi.ordermanagereventuatelocal.command;

import com.randi.ordermanagereventuatelocal.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class InitiateOrderCommand implements OrderCommand {
    private String customerAggregateId;
    private Product orderProduct;
}
