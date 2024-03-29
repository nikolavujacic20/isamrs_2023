package com.isamrs.isamrs_projekat.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@DiscriminatorValue("registered_user")
public class RegisteredUser  extends User {

    public RegisteredUser(){

    }

    public RegisteredUser(String email, String password) {
        super(email, password);
    }

    public RegisteredUser(String firstName, String lastName, String email, String password, Boolean active, Boolean verified, Set<Authority> authority) {
        super(firstName, lastName, email, password, active, verified, authority);
    }

    public RegisteredUser(String firstName, String lastName, byte[] profilePicture, String phoneNumber, String address, String email, String password, Boolean isActive, Boolean isBlocked, Set<Authority> authority, Timestamp lastPasswordResetDate) {
        super(firstName, lastName, profilePicture, phoneNumber, address, email, password, isActive, isBlocked, authority, lastPasswordResetDate);
    }

    public RegisteredUser(String email2, String password2, String firstName2, String lastName2) {
        super(email2, password2, firstName2, lastName2);
    }



}
