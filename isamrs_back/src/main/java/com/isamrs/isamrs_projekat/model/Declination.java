package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Declination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ride_id")
    private Ride ride;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime declinationTime;

    public Declination() {
    }

    public Declination(Long id, Ride ride, String reason, User user, LocalDateTime declinationTime) {
        this.id = id;
        this.ride = ride;
        this.reason = reason;
        this.user = user;
        this.declinationTime = declinationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDeclinationTime() {
        return declinationTime;
    }

    public void setDeclinationTime(LocalDateTime declinationTime) {
        this.declinationTime = declinationTime;
    }
}
