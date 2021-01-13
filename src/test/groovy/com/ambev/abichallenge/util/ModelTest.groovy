package com.ambev.abichallenge.util

import static com.ambev.abichallenge.ObjectMother.*
import com.ambev.abichallenge.entity.Type
import spock.lang.Specification

class ModelTest extends Specification {

    def capacities = [A: 10, B: 20, C: 30, D: 40, E: 50]


    def "Convert DTO to entity - Vehicle"(){
        given:

        def vehicle = buildVehicle('F100', 'B' , new Type('A'))
        def vehicleRequest = buildVehicleRequest('F100', 'B','A')

        when:
        def convertedVehicle = vehicleRequest.toEntity()

        then:
        convertedVehicle.location == vehicle.location
        convertedVehicle.model == vehicle.model
        convertedVehicle.type == vehicle.type
        convertedVehicle.type.capacity == capacities.get(vehicle.type.type)
    }

    def "Convert DTO to entity - DeliveryOrder"(){

        given:

        def deliveryOrder = buildDeliveryOrder('Emporio da cerveja', 'A', 30)
        def deliveryOrderRequest = buildDeliveryOrderRequest('Emporio da cerveja', 'A', 30)


        when:
        def result = deliveryOrderRequest.toEntity()

        then:
        result == deliveryOrder

    }

    def "Convert DTO to entity - VehicleRequest"(){

    }

    def "Convert DTO to entity - DeliveryOrderRequest"(){

    }

}
