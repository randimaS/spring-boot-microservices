package com.randi.ordermanagereventuatelocal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private String nic;
    private String orderAggregateId;
}
