package com.ambev.abichallenge.model.dto;

import lombok.Data;

@Data
public class VehicleRequest {

    private long id;
    private String model;
    private String location;
    private String type;


}
