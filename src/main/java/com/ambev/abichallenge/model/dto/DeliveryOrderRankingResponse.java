package com.ambev.abichallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderRankingResponse {

   Set<VehicleScore> results;


}
