package com.isamrs.isamrs_projekat.service;

import com.isamrs.isamrs_projekat.dto.DriverDTO;
import com.isamrs.isamrs_projekat.model.Driver;
import com.isamrs.isamrs_projekat.model.Vehicle;
import com.isamrs.isamrs_projekat.repository.DriverRepository;
import com.isamrs.isamrs_projekat.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VehicleRepository vehicleRepository;

    public Driver createDriver(DriverDTO driverDto) {
        Driver driver = new Driver();

        driver.setId(driverDto.getId());
        driver.setFirstName(driverDto.getFirstName());
        driver.setLastName(driverDto.getLastName());
        driver.setPhoneNumber(driverDto.getPhoneNumber());
        driver.setAddress(driverDto.getAddress());
        driver.setEmail(driverDto.getEmail());
        driver.setPassword(passwordEncoder.encode(driverDto.getPassword()));

        driver.setRides(driverDto.getRides());
        driver.setWorkingHours(driverDto.getWorkingHours());

        // get the vehicle from the repository using the vehicle id from driverDto
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(driverDto.getVehicle().getId());

        if(optionalVehicle.isPresent()) {
            driver.setVehicle(optionalVehicle.get());
        } else {
            driver.setVehicle(null);
        }

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