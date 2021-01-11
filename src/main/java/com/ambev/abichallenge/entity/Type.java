package com.ambev.abichallenge.entity;

import com.ambev.abichallenge.enums.VehicleTypeMapping;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Type {

    private String type;

    private int capacity;

    public Type(){}

    public Type(String type){
        this.type = type;
        this.capacity = VehicleTypeMapping.of(type).capacity();
    }
}
