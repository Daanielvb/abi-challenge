package com.ambev.abichallenge.model.dto;

import com.ambev.abichallenge.entity.DeliveryOrder;
import lombok.Data;

@Data
public class DeliveryOrderRequest {

    private String store;

    private String location;

    private int quantity;

    public DeliveryOrder toEntity(){
        return DeliveryOrder.builder()
                .location(location)
                .quantity(quantity)
                .store(store)
                .build();
    }

}
