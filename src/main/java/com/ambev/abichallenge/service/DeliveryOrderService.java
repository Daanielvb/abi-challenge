package com.ambev.abichallenge.service;

import com.ambev.abichallenge.distance.LocationMap;
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
         ShortestDistance shortestDistance = new ShortestDistance(LocationMap.nodes, LocationMap.edges);
         for(Vehicle vehicle : vehicles){
             shortestDistance.calculateDistances(new Node(vehicle.getLocation()));
             LinkedList<Node> path = shortestDistance.getPath(new Node(order.getLocation()));
             int score = ScoreCalculator.calculateScore(vehicle.getType().getCapacity(), order.getQuantity(), path.size());
             VehicleScore vehicleScore = VehicleScore.of(vehicle, score);
             scores.add(vehicleScore);
         }
         return scores;
    }

}
