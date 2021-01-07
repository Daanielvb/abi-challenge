package com.ambev.abichallenge.service;

import com.ambev.abichallenge.model.Type;
import com.ambev.abichallenge.model.Vehicle;
import com.ambev.abichallenge.model.dto.VehicleRequest;
import com.ambev.abichallenge.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository repository;

    public Optional<Vehicle> save(VehicleRequest request){
        return Optional.ofNullable(repository.save(toEntity(request)));
    }

    public Optional<Vehicle> read(Long id){
        return repository.findById(id);
    }

    private Vehicle toEntity(VehicleRequest request){
        return Vehicle.builder()
                .type(new Type(request.getType()))
                .location(request.getLocation())
                .model(request.getModel())
                .build();
    }




}
