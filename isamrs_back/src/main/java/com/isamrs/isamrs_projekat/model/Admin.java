package com.isamrs.isamrs_projekat.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "admins")
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin(){

    }

    public Admin(String email, String password) {
        super(email, password);
    }

    public Admin(Long id, String firstName, String lastName, String email, String password, Boolean active, Boolean verified, Set<Authority> authority) {
        super(id, firstName, lastName, email, password, active, verified, authority);
    }

    public Admin(Long id, String firstName, String lastName, byte[] profilePicture, String phoneNumber, String address, String email, String password, Boolean isActive, Boolean isBlocked, Set<Authority> authority, Timestamp lastPasswordResetDate) {
        super(id, firstName, lastName, profilePicture, phoneNumber, address, email, password, isActive, isBlocked, authority, lastPasswordResetDate);
    }

    public Admin(String email2, String password2, String firstName2, String lastName2) {
        super(email2, password2, firstName2, lastName2);
    }



}