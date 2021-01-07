package com.ambev.abichallenge.enums;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum VehicleTypeMapping {

    VEHICLE_TYPE_A(VehicleType.A, 10),
    VEHICLE_TYPE_B(VehicleType.B, 20),
    VEHICLE_TYPE_C(VehicleType.C, 30),
    VEHICLE_TYPE_D(VehicleType.D, 40),
    VEHICLE_TYPE_E(VehicleType.E, 50);


    private static final Map<String, VehicleTypeMapping> lookup = new HashMap<>();

    static{
        lookup.put("A", VEHICLE_TYPE_A);
        lookup.put("B", VEHICLE_TYPE_B);
        lookup.put("C", VEHICLE_TYPE_C);
        lookup.put("D", VEHICLE_TYPE_D);
        lookup.put("E", VEHICLE_TYPE_E);
    }

    private VehicleType type;

    private int capacity;

    public VehicleType getType() {
        return type;
    }

    public int capacity() {
        return capacity;
    }

    VehicleTypeMapping(VehicleType type, int capacity){
        this.type = type;
        this.capacity = capacity;
    }

    public static VehicleTypeMapping of(String type){
        return VehicleTypeMapping.lookup.getOrDefault(type, null);
    }






}
