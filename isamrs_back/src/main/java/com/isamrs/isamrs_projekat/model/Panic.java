package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Panic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ride_id")
    private Ride currentRide;

    private LocalDateTime panicTime;
    private String reason;

    public Panic() {
    }

    public Panic(Long id, User user, Ride currentRide, LocalDateTime panicTime, String reason) {
        this.id = id;
        this.user = user;
        this.currentRide = currentRide;
        this.panicTime = panicTime;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public LocalDateTime getPanicTime() {
        return panicTime;
    }

    public void setPanicTime(LocalDateTime panicTime) {
        this.panicTime = panicTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
