package com.ambev.abichallenge.model.dto;

import lombok.Data;

@Data
public class DeliveryOrderRequest {

    private String store;

    private String location;

    private int quantity;


}
