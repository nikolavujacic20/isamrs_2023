package com.isamrs.isamrs_projekat.dto;

import com.isamrs.isamrs_projekat.model.Authority;
import com.isamrs.isamrs_projekat.model.Ride;
import com.isamrs.isamrs_projekat.model.Vehicle;
import com.isamrs.isamrs_projekat.model.WorkingHours;

import java.util.List;
import java.util.Set;

public class DriverDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;

    private List<Ride> rides;
    private WorkingHours workingHours;
    private Vehicle vehicle;

    public DriverDTO() {
    }

    public DriverDTO(List<Ride> rides, WorkingHours workingHours, Vehicle vehicle) {
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public DriverDTO(Long id, String firstName, String lastName, String phoneNumber,
                     String address, String email, String password,
                     Set<Authority> authority, List<Ride> rides,
                     WorkingHours workingHours, Vehicle vehicle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
