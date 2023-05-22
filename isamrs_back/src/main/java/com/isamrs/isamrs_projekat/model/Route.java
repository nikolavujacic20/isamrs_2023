package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToOne
    private Location startLocation;

    @OneToOne
    private Location endLocation;

    private Double distance;
    private LocalDateTime estimatedTime;
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "ride_id")
    private Ride ride;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = true)
    private Payment payment;

    public Route() {
    }

    public Route(Long id, LocalDateTime startTime, LocalDateTime endTime,
                 Location startLocation, Location endLocation, Double distance,
                 LocalDateTime estimatedTime, Double cost, Ride ride, Payment payment)
    {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.cost = cost;
        this.ride = ride;
        this.payment = payment;
    }

    public Route(Long id, LocalDateTime startTime, LocalDateTime endTime, Location startLocation,
                 Location endLocation, Double distance, LocalDateTime estimatedTime, Double cost,
                 Payment payment) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.cost = cost;
        this.payment = payment;
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

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public LocalDateTime getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(LocalDateTime estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Payment getPayment() {
        return payment;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


}
