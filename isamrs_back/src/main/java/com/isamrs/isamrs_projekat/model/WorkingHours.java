package com.isamrs.isamrs_projekat.model;

import org.hibernate.jdbc.Work;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class WorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime startTime;

    private LocalTime endTime;

    @OneToOne(mappedBy = "workingHours")
    private Driver driver;

    public WorkingHours(){

    }
    public WorkingHours(Long id, LocalTime startTime, LocalTime endTime, Driver driver) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
