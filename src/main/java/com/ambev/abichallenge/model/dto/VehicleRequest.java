package com.ambev.abichallenge.model.dto;

import com.ambev.abichallenge.entity.Type;
import com.ambev.abichallenge.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    private String model;
    private String location;
    private String type;

    public Vehicle toEntity(){
        return Vehicle.builder()
                .type(new Type(type))
                .location(location)
                .model(model)
                .build();
    }


}
