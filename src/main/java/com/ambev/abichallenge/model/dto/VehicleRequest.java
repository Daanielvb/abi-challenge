package com.ambev.abichallenge.model.dto;

import com.ambev.abichallenge.entity.Type;
import com.ambev.abichallenge.entity.Vehicle;
import lombok.Data;

@Data
public class VehicleRequest {

    private long id;
    private String model;
    private String location;
    private String type;

    public Vehicle toEntity(){
        return Vehicle.builder()
                .id(id)
                .type(new Type(type))
                .location(location)
                .model(model)
                .build();
    }


}
