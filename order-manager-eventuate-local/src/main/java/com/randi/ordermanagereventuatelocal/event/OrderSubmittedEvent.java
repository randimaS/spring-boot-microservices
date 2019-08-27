package com.randi.ordermanagereventuatelocal.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSubmittedEvent implements OrderEvent {
    private boolean orderStatus = true;
}
