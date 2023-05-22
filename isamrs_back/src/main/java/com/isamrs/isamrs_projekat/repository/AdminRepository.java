package com.isamrs.isamrs_projekat.repository;

import com.isamrs.isamrs_projekat.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

    Admin findByEmail(String email);

    @Query(value = "SELECT * FROM USERS WHERE TYPE = 'admin' AND ACTIVE = TRUE", nativeQuery = true)
    List<Admin> findAllAdmin();


}
