package com.randi.ordermanagereventuatelocal.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreatedEvent implements CustomerEvent {
    private String nic;
    private String firstName;
    private String lastName;

}
