package com.isamrs.isamrs_projekat.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Authority implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String role;

    public Authority() {
        super();
    }

    public Authority(String role) {
        super();
        this.role = role;
    }

    public Authority(Long id, String role) {
        super();
        this.id = id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authority a = (Authority) o;
        if (a.getId() == null || id == null) {
            if(a.getRole().equals(getRole())){
                return true;
            }
            return false;
        }
        return Objects.equals(id, a.getId());
    }

}
