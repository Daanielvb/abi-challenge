package com.ambev.abichallenge.service;

import com.ambev.abichallenge.model.DeliveryOrder;
import com.ambev.abichallenge.model.dto.DeliveryOrderRequest;
import com.ambev.abichallenge.repository.DeliveryOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeliveryOrderService {

    private final DeliveryOrderRepository repository;

    public DeliveryOrder save(DeliveryOrderRequest request){
        return repository.save(toEntity(request));
    }

    private DeliveryOrder toEntity(DeliveryOrderRequest request){
        return DeliveryOrder.builder()
                .location(request.getLocation())
                .quantity(request.getQuantity())
                .store(request.getStore())
                .build();
    }
}
