package com.randi.ordermanagereventuatelocal.controller;

import com.randi.ordermanagereventuatelocal.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InitiateOrderRequest {
    private String customerAggregateId;
    private Product product;
}
