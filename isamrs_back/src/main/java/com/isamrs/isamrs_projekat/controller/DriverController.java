package com.isamrs.isamrs_projekat.controller;

import com.isamrs.isamrs_projekat.model.Driver;
import com.isamrs.isamrs_projekat.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable(value = "id") Long driverId) {
        return driverService.getDriverById(driverId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable(value = "id") Long driverId, @RequestBody Driver driverDetails) {
        return driverService.updateDriver(driverId, driverDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable(value = "id") Long driverId) {
        return driverService.deleteDriver(driverId);
    }
}
