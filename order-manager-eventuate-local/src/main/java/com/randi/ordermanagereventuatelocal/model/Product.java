package com.randi.ordermanagereventuatelocal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
}
