package com.randi.ordermanagereventuatelocal.event;

import com.randi.ordermanagereventuatelocal.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInitiatedEvent implements OrderEvent {
    private String customerAggregateId;
    private Product orderProduct;
}
