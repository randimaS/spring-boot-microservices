package com.randi.ordermanagereventuatelocal.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderCommand implements CustomerCommand {
    private String orderAggregateId;
}
