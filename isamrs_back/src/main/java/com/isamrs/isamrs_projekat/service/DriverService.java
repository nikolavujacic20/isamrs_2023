package com.isamrs.isamrs_projekat.service;

import com.isamrs.isamrs_projekat.model.Driver;
import com.isamrs.isamrs_projekat.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public ResponseEntity<Driver> getDriverById(Long driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);

        if(driver.isPresent()) {
            return ResponseEntity.ok().body(driver.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Driver> updateDriver(Long driverId, Driver driverDetails) {
        Optional<Driver> driver = driverRepository.findById(driverId);

        if(driver.isPresent()) {
            Driver updatedDriver = driver.get();
            updatedDriver.setDocuments(driverDetails.getDocuments());
            updatedDriver.setWorkingHours(driverDetails.getWorkingHours());
            updatedDriver.setVehicle(driverDetails.getVehicle());
            driverRepository.save(updatedDriver);
            return ResponseEntity.ok(updatedDriver);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> deleteDriver(Long driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);

        if(driver.isPresent()) {
            driverRepository.delete(driver.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}