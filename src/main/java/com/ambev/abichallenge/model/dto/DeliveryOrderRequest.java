package com.ambev.abichallenge.model.dto;

import com.ambev.abichallenge.entity.DeliveryOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
