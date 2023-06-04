package com.isamrs.isamrs_projekat.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("DRIVER")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Driver extends User {

    @Lob
    @Column(nullable = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)  // Ignore this field when it's null
    @JsonIgnore
    protected byte[] documents;

    @OneToMany(mappedBy = "driver")
    protected List<Ride> rides;

    @OneToOne
    @JoinColumn(name = "working_hours_id")
    private WorkingHours workingHours;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    protected Vehicle vehicle;

    public Driver(){
    }

    public Driver(byte[] documents, List<Ride> rides, WorkingHours workingHours, Vehicle vehicle) {
        this.documents = documents;
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public Driver(String email, String password, byte[] documents, List<Ride> rides, WorkingHours workingHours, Vehicle vehicle) {
        super(email, password);
        this.documents = documents;
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public Driver(String firstName, String lastName, String email, String password, Boolean active, Boolean verified, Set<Authority> authority, byte[] documents, List<Ride> rides, WorkingHours workingHours, Vehicle vehicle) {
        super(firstName, lastName, email, password, active, verified, authority);
        this.documents = documents;
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public Driver(Long id, String firstName, String lastName, byte[] profilePicture, String phoneNumber, String address, String email, String password, Boolean isActive, Boolean isBlocked, Set<Authority> authority, Timestamp lastPasswordResetDate, byte[] documents, List<Ride> rides, WorkingHours workingHours, Vehicle vehicle) {
        super(firstName, lastName, profilePicture, phoneNumber, address, email, password, isActive, isBlocked, authority, lastPasswordResetDate);
        this.documents = documents;
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public Driver(String email2, String password2, String firstName2, String lastName2, byte[] documents, List<Ride> rides, WorkingHours workingHours, Vehicle vehicle) {
        super(email2, password2, firstName2, lastName2);
        this.documents = documents;
        this.rides = rides;
        this.workingHours = workingHours;
        this.vehicle = vehicle;
    }

    public Driver(byte[] documents, List<Ride> rides, Vehicle vehicle) {
        this.documents = documents;
        this.rides = rides;
        this.vehicle = vehicle;
    }

    public Driver(String email, String password, byte[] documents, List<Ride> rides, Vehicle vehicle) {
        super(email, password);
        this.documents = documents;
        this.rides = rides;
        this.vehicle = vehicle;
    }

    public Driver(String firstName, String lastName, String email, String password, Boolean active, Boolean verified, Set<Authority> authority, byte[] documents, List<Ride> rides, Vehicle vehicle) {
        super(firstName, lastName, email, password, active, verified, authority);
        this.documents = documents;
        this.rides = rides;
        this.vehicle = vehicle;
    }

    public Driver(String firstName, String lastName, byte[] profilePicture, String phoneNumber, String address, String email, String password, Boolean isActive, Boolean isBlocked, Set<Authority> authority, Timestamp lastPasswordResetDate, byte[] documents, List<Ride> rides, Vehicle vehicle) {
        super(firstName, lastName, profilePicture, phoneNumber, address, email, password, isActive, isBlocked, authority, lastPasswordResetDate);
        this.documents = documents;
        this.rides = rides;
        this.vehicle = vehicle;
    }

    public Driver(String email2, String password2, String firstName2, String lastName2, byte[] documents, List<Ride> rides, Vehicle vehicle) {
        super(email2, password2, firstName2, lastName2);
        this.documents = documents;
        this.rides = rides;
        this.vehicle = vehicle;
    }

    public byte[] getDocuments() {
        return documents;
    }

    public void setDocuments(byte[] documents) {
        this.documents = documents;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }
}
