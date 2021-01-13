package com.ambev.abichallenge.service;

import com.ambev.abichallenge.entity.Type;
import com.ambev.abichallenge.entity.Vehicle;
import com.ambev.abichallenge.model.dto.VehicleRequest;
import com.ambev.abichallenge.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository repository;

    public Optional<Vehicle> save(VehicleRequest request){
        return Optional.ofNullable(repository.save(request.toEntity()));
    }

    public Set<Vehicle> findAll(){
        return new HashSet<>(repository.findAll());
    }

}
