package com.ambev.abichallenge.controller

import com.ambev.abichallenge.AbiChallengeApplication
import com.ambev.abichallenge.entity.Vehicle
import com.ambev.abichallenge.service.DeliveryOrderService
import com.ambev.abichallenge.service.VehicleService
import org.spockframework.spring.SpringBean
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Ignore
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = AbiChallengeApplication.class)
@ActiveProfiles("integTest")
@Ignore
class ControllerTest extends Specification{

    @SpringBean
    DeliveryOrderService deliveryOrderService = Mock(DeliveryOrderService)

    @SpringBean
    VehicleService vehicleService = Mock(VehicleService)

    private MockMvc mockMvc


    def "Should return correct status and response - POST /vehicle " () {
        given:
        vehicleService.save(_) >> new Optional<Vehicle>()

        when:
        def expected = mockMvc.perform(
                post('/v1/vehicle')
                        .content('{ "model": "F1000", "location" : "C", "type" : "E"}')
                        .header("Content-Type", "application/json"))


        then:

        expected.andExpect(status().isCreated())

    }

    def "Should return correct status and response - POST /order" () {
        given:
        deliveryOrderService.save(_) >> new Optional<DeliveryOrderService>()

        when:
        def expected = mockMvc.perform(
                post('/v1/order')
                        .content('{ "store": "Emporio da cerveja", "location" : "C", "quantity" : "20"}')
                        .header("Content-Type", "application/json"))


        then:

        expected.andExpect(status().isCreated())

    }
}
