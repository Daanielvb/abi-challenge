package com.ambev.abichallenge.controller.v1;


import com.ambev.abichallenge.model.Vehicle;
import com.ambev.abichallenge.model.dto.VehicleRequest;
import com.ambev.abichallenge.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "Vehicle API")
@RestController
@RequestMapping(value = "v1/vehicle")
@AllArgsConstructor
public class VehicleResource {

    private final VehicleService service;

    @PostMapping
    @ApiOperation(value = "Stores a vehicle in the database")
    @ApiResponses( value = {
            @ApiResponse(code = 202, message = "Resource created"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Something Unexpected Happened")
    })
    public ResponseEntity<Vehicle> storeVehicle(@RequestBody VehicleRequest request){
        try {
            return ResponseEntity.ok(service.save(request).get());
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
