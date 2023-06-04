package com.isamrs.isamrs_projekat.repository;

import com.isamrs.isamrs_projekat.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
