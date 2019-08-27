package com.randi.ordermanagereventuatelocal.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCustomerCommand  implements CustomerCommand{
    private String nic;
    private String firstName;
    private String lastName;
}
