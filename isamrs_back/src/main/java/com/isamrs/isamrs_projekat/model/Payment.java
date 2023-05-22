package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User payingUser;

    @OneToMany(mappedBy = "payment")
    private List<Route> userRoutes;

    @ManyToOne
    @JoinColumn(name = "ride_id")
    private Ride ride;

    private LocalDateTime paymentDate;
    private Double totalPaymentCost;

    public Payment() {
    }

    public Payment(Long id, PaymentType paymentType, User payingUser,
                   List<Route> userRoutes, LocalDateTime paymentDate,
                   Double totalPaymentCost) {
        this.id = id;
        this.paymentType = paymentType;
        this.payingUser = payingUser;
        this.userRoutes = userRoutes;
        this.paymentDate = paymentDate;
        this.totalPaymentCost = totalPaymentCost;
    }

    public Payment(Long id, PaymentType paymentType, User payingUser,
                   List<Route> userRoutes, Ride ride, LocalDateTime paymentDate,
                   Double totalPaymentCost) {
        this.id = id;
        this.paymentType = paymentType;
        this.payingUser = payingUser;
        this.userRoutes = userRoutes;
        this.ride = ride;
        this.paymentDate = paymentDate;
        this.totalPaymentCost = totalPaymentCost;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public User getPayingUser() {
        return payingUser;
    }

    public void setPayingUser(User payingUser) {
        this.payingUser = payingUser;
    }

    public List<Route> getUserRoutes() {
        return userRoutes;
    }

    public void setUserRoutes(List<Route> userRoutes) {
        this.userRoutes = userRoutes;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getTotalPaymentCost() {
        return totalPaymentCost;
    }

    public void setTotalPaymentCost(Double totalPaymentCost) {
        this.totalPaymentCost = totalPaymentCost;
    }
}
