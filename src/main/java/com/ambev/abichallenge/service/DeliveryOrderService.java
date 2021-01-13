package com.ambev.abichallenge.service;

import com.ambev.abichallenge.distance.Node;
import com.ambev.abichallenge.distance.ShortestDistance;
import com.ambev.abichallenge.entity.DeliveryOrder;
import com.ambev.abichallenge.entity.Vehicle;
import com.ambev.abichallenge.model.dto.DeliveryOrderRankingResponse;
import com.ambev.abichallenge.model.dto.DeliveryOrderRequest;
import com.ambev.abichallenge.model.dto.VehicleScore;
import com.ambev.abichallenge.repository.DeliveryOrderRepository;
import com.ambev.abichallenge.util.ScoreCalculator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.*;

@Service
@AllArgsConstructor
public class DeliveryOrderService {

    private final DeliveryOrderRepository repository;

    private final VehicleService vehicleService;

    public DeliveryOrder save(DeliveryOrderRequest request){
        return repository.save(request.toEntity());
    }

    public DeliveryOrder findById(Long id){
        return repository.findById(id).orElseThrow(NoResultException::new);
    }

    public DeliveryOrderRankingResponse rankVehicles(Long orderId){
        DeliveryOrder order = findById(orderId);
        Set<VehicleScore> vehicleScores = sortVehiclesByLocation(order);
        return new DeliveryOrderRankingResponse(vehicleScores);
    }

    public Set<VehicleScore> sortVehiclesByLocation(DeliveryOrder order){
         Set<Vehicle> vehicles  = vehicleService.findAll();
         SortedSet<VehicleScore> scores = new TreeSet<>();
         for(Vehicle vehicle : vehicles){
             int shortestDistance = ShortestDistance.find(new Node(vehicle.getLocation()), new Node(order.getLocation()));
             int score = ScoreCalculator.calculateScore(vehicle.getType().getCapacity(), order.getQuantity(), shortestDistance);
             VehicleScore vehicleScore = VehicleScore.of(vehicle, score);
             scores.add(vehicleScore);
         }
         return scores;
    }

}
