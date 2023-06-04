package com.isamrs.isamrs_projekat.controller;

import com.isamrs.isamrs_projekat.model.Vehicle;
import com.isamrs.isamrs_projekat.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId) {
            Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);

        if(vehicle.isPresent()) {
            return ResponseEntity.ok().body(vehicle.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId, @RequestBody Vehicle vehicleDetails) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);

        if(vehicle.isPresent()) {
            Vehicle updatedVehicle = vehicle.get();
            updatedVehicle.setVehicleModel(vehicleDetails.getVehicleModel());
            updatedVehicle.setVehicleType(vehicleDetails.getVehicleType());
            updatedVehicle.setRegistrationPlates(vehicleDetails.getRegistrationPlates());
            updatedVehicle.setSeatNumber(vehicleDetails.getSeatNumber());
            updatedVehicle.setCurrentLocation(vehicleDetails.getCurrentLocation());
            updatedVehicle.setBabyTransport(vehicleDetails.getBabyTransport());
            updatedVehicle.setPetTransport(vehicleDetails.getPetTransport());
            vehicleRepository.save(updatedVehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable(value = "id") Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);

        if(vehicle.isPresent()) {
            vehicleRepository.delete(vehicle.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
