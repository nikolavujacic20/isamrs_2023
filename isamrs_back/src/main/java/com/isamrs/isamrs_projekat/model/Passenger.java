package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "passengers")
@DiscriminatorValue("PASSENGER")
public class Passenger extends User {
    @ManyToMany(mappedBy = "passengers")
    private List<Ride> rides;

    @ManyToMany
    @JoinTable(
            name = "passenger_favorite_routes",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> favoriteRoutes;

    public Passenger(){

    }

    public Passenger(List<Ride> rides, List<Route> favoriteRoutes) {
        this.rides = rides;
        this.favoriteRoutes = favoriteRoutes;
    }

    public Passenger(String email, String password, List<Ride> rides, List<Route> favoriteRoutes) {
        super(email, password);
        this.rides = rides;
        this.favoriteRoutes = favoriteRoutes;
    }

    public Passenger(Long id, String firstName, String lastName, String email, String password, Boolean active, Boolean verified, Set<Authority> authority, List<Ride> rides, List<Route> favoriteRoutes) {
        super(id, firstName, lastName, email, password, active, verified, authority);
        this.rides = rides;
        this.favoriteRoutes = favoriteRoutes;
    }

    public Passenger(Long id, String firstName, String lastName, byte[] profilePicture, String phoneNumber, String address, String email, String password, Boolean isActive, Boolean isBlocked, Set<Authority> authority, Timestamp lastPasswordResetDate, List<Ride> rides, List<Route> favoriteRoutes) {
        super(id, firstName, lastName, profilePicture, phoneNumber, address, email, password, isActive, isBlocked, authority, lastPasswordResetDate);
        this.rides = rides;
        this.favoriteRoutes = favoriteRoutes;
    }

    public Passenger(String email2, String password2, String firstName2, String lastName2, List<Ride> rides, List<Route> favoriteRoutes) {
        super(email2, password2, firstName2, lastName2);
        this.rides = rides;
        this.favoriteRoutes = favoriteRoutes;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public List<Route> getFavoriteRoutes() {
        return favoriteRoutes;
    }

    public void setFavoriteRoutes(List<Route> favoriteRoutes) {
        this.favoriteRoutes = favoriteRoutes;
    }
}
