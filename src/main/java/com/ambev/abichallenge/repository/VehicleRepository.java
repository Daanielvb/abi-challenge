package com.ambev.abichallenge.repository;

import com.ambev.abichallenge.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
