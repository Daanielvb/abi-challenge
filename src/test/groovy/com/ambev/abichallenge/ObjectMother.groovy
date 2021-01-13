package com.ambev.abichallenge

import com.ambev.abichallenge.entity.DeliveryOrder
import com.ambev.abichallenge.entity.Vehicle
import com.ambev.abichallenge.model.dto.DeliveryOrderRequest
import com.ambev.abichallenge.model.dto.VehicleRequest

class ObjectMother {

    static buildVehicle(model, location,  type){
        return Vehicle.builder().model(model).location(location).type(type).build()
    }

    static buildDeliveryOrder(store, location, qty){
        return DeliveryOrder.builder().store(store).location(location).quantity(qty).build()
    }

    static buildDeliveryOrderRequest(store, location, qty){
        return DeliveryOrderRequest.builder().store(store).location(location).quantity(qty).build()
    }

    static buildVehicleRequest(model, location, type){
        return new VehicleRequest(model, location, type)
    }
}
