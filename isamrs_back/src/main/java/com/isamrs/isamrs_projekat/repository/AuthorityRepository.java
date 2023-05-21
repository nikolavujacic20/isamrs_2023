package com.isamrs.isamrs_projekat.repository;

import com.isamrs.isamrs_projekat.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
    Authority findByRole(String role);
}
