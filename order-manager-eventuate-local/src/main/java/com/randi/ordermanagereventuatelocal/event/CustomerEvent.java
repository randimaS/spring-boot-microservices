package com.randi.ordermanagereventuatelocal.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity="com.randi.ordermanagereventuatelocal.aggregate.CustomerAggregate")
public interface CustomerEvent extends Event{
}
