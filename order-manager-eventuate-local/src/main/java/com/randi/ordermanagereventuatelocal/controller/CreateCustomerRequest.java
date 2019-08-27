package com.randi.ordermanagereventuatelocal.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerRequest {
    private String nic;
    private String firstName;
    private String lastName;
}
