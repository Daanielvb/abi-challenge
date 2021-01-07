package com.ambev.abichallenge.controller.v1;


import com.ambev.abichallenge.model.DeliveryOrder;
import com.ambev.abichallenge.model.Vehicle;
import com.ambev.abichallenge.model.dto.DeliveryOrderRequest;
import com.ambev.abichallenge.model.dto.VehicleRequest;
import com.ambev.abichallenge.service.DeliveryOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.mapstruct.Context;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@Api(value = "Order API")
@RestController
@RequestMapping(value = "v1/order")
@AllArgsConstructor
public class DeliveryOrderResource {

    private DeliveryOrderService service;

    @PostMapping
    @ApiOperation(value = "Stores a delivery order in the database")
    @ApiResponses( value = {
            @ApiResponse(code = 202, message = "Resource created"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    public ResponseEntity<DeliveryOrder> save(@RequestBody DeliveryOrderRequest request){
        try {
            DeliveryOrder order = service.save(request);

            //TODO: Get the URI dynamically
            URI location = new URI("/v1/order/" + order.getId());
            return ResponseEntity.created(location).body(order);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
