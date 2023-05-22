package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalCost;

    @OneToMany(mappedBy = "ride")
    private List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    // Considering passengers as User
    @ManyToMany
    @JoinTable(
            name = "ride_passengers",
            joinColumns = @JoinColumn(name = "ride_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> passengers;

    // Assuming Route is another entity that contains route details
    @OneToMany(mappedBy = "ride")
    private List<Route> routes;

    private LocalDateTime estimatedTime;

    @OneToMany(mappedBy = "ride")
    private List<Review> reviews;

    private String rideStatus;

    // Considering Declination as another entity
    @OneToOne(mappedBy = "ride")
    private Declination declination;

    private Boolean panicButton;
    private Boolean babyTransport;
    private Boolean petTransport;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    private Boolean splitFare;

    public Ride() {
    }

    public Ride(Long id, LocalDateTime startTime, LocalDateTime endTime, Double totalCost, Driver driver,
                List<User> passengers, List<Route> routes, LocalDateTime estimatedTime,
                List<Review> reviews, String rideStatus, Declination declination,
                Boolean panicButton, Boolean babyTransport, Boolean petTransport,
                VehicleType vehicleType, List<Payment> payments, Boolean splitFare) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalCost = totalCost;
        this.driver = driver;
        this.passengers = passengers;
        this.routes = routes;
        this.estimatedTime = estimatedTime;
        this.reviews = reviews;
        this.rideStatus = rideStatus;
        this.declination = declination;
        this.panicButton = panicButton;
        this.babyTransport = babyTransport;
        this.petTransport = petTransport;
        this.vehicleType = vehicleType;
        this.payments = payments;
        this.splitFare = splitFare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public LocalDateTime getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(LocalDateTime estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(String rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Declination getDeclination() {
        return declination;
    }

    public void setDeclination(Declination declination) {
        this.declination = declination;
    }

    public Boolean getPanicButton() {
        return panicButton;
    }

    public void setPanicButton(Boolean panicButton) {
        this.panicButton = panicButton;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Boolean getSplitFare() {
        return splitFare;
    }

    public void setSplitFare(Boolean splitFare) {
        this.splitFare = splitFare;
    }
}
