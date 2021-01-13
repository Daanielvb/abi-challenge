package com.ambev.abichallenge.entity;

import com.ambev.abichallenge.model.dto.DeliveryOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryOrder {

    @Id
    @GeneratedValue
    private long id;

    private String store;

    private String location;

    private int quantity;

    private boolean completed;


    public DeliveryOrder toEntity(DeliveryOrderRequest request){
        return DeliveryOrder.builder()
                .location(request.getLocation())
                .quantity(request.getQuantity())
                .store(request.getStore())
                .build();
    }


}
