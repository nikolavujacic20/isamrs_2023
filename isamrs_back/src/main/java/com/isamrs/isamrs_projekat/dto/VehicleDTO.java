package com.isamrs.isamrs_projekat.dto;

import com.isamrs.isamrs_projekat.model.VehicleType;

public class VehicleDTO {
    private Long id;
    private DriverDTO driver;

    private String vehicleModel;

    private VehicleType vehicleType;

    private String registrationPlates;
    private int seatNumber;
    private String currentLocation;
    private Boolean babyTransport;
    private Boolean petTransport;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id, DriverDTO driver, String vehicleModel, VehicleType vehicleType,
                      String registrationPlates, int seatNumber, String currentLocation,
                      Boolean babyTransport, Boolean petTransport) {
        this.id = id;
        this.driver = driver;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.registrationPlates = registrationPlates;
        this.seatNumber = seatNumber;
        this.currentLocation = currentLocation;
        this.babyTransport = babyTransport;
        this.petTransport = petTransport;
    }

    public VehicleDTO(Long id, DriverDTO driver, String vehicleModel, VehicleType vehicleType,
                      String registrationPlates, int seatNumber, String currentLocation) {
        this.id = id;
        this.driver = driver;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.registrationPlates = registrationPlates;
        this.seatNumber = seatNumber;
        this.currentLocation = currentLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationPlates() {
        return registrationPlates;
    }

    public void setRegistrationPlates(String registrationPlates) {
        this.registrationPlates = registrationPlates;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Boolean getBabyTransport() {
        return babyTransport;
    }

    public void setBabyTransport(Boolean babyTransport) {
        this.babyTransport = babyTransport;
    }

    public Boolean getPetTransport() {
        return petTransport;
    }

    public void setPetTransport(Boolean petTransport) {
        this.petTransport = petTransport;
    }
}
