package com.isamrs.isamrs_projekat.repository;

import com.isamrs.isamrs_projekat.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
