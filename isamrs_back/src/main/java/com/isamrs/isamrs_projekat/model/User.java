package com.isamrs.isamrs_projekat.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = true)
    protected String firstName;

    @Column(nullable = true)
    protected String lastName;

    @Lob
    @Column(nullable = true)
    protected byte[] profilePicture;

    @Column(nullable = true)
    protected String phoneNumber;

    @Column(nullable = true)
    protected String address;

    @Column(unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = true)
    protected Boolean isActive;

    @Column(nullable = true)
    protected Boolean isBlocked;


    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name = "user_id", nullable = false)
    protected Set<Authority> authority;

    @Column(name = "last_password_reset_date",nullable = true)
    private Timestamp lastPasswordResetDate;

    public User() {
        super();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password, Boolean active,
                Boolean verified, Set<Authority> authority) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = active;
        this.isBlocked = verified;
        this.authority = authority;
    }

    public User(String firstName, String lastName, byte[] profilePicture, String phoneNumber,
                String address, String email, String password, Boolean isActive, Boolean isBlocked,
                Set<Authority> authority, Timestamp lastPasswordResetDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.isBlocked = isBlocked;
        this.authority = authority;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public User(String email2, String password2, String firstName2, String lastName2) {
        this.firstName = firstName2;
        this.lastName = lastName2;
        this.email = email2;
        this.password = password2;
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
        Timestamp now = new Timestamp(new Date().getTime());
        this.setLastPasswordResetDate(now);
        this.password = password;
    }

    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> set) {
        this.authority = set;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authority;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + ", active=" + isActive
                + ", authority=" + authority + ", lastPasswordResetDate=" + lastPasswordResetDate + "]";
    }



}
