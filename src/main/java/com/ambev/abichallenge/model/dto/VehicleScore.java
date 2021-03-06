package com.ambev.abichallenge.model.dto;

import com.ambev.abichallenge.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleScore implements Comparable<VehicleScore> {

    @JsonProperty("id_vehicle")
    private Long id;

    private String model;

    private String location;

    private int capacity;

    private Double score;

    @Override
    public int compareTo(VehicleScore o) {
        return o.score.compareTo(this.score);
    }

    public static VehicleScore of(Vehicle vehicle, double score){
        return VehicleScore.builder()
                .id(vehicle.getId())
                .capacity(vehicle.getType().getCapacity())
                .model(vehicle.getModel())
                .location(vehicle.getLocation())
                .score(score)
                .build();
    }
}
