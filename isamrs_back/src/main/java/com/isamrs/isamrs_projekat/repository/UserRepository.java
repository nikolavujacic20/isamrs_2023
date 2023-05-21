package com.isamrs.isamrs_projekat.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrs.isamrs_projekat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

    List<User> findAllByIsActive(boolean b);

    Optional<User> findByIdAndIsActive(Long id, boolean b);

    User findByEmailAndIsActive(String email, boolean b);

    Page<User> findByIsActive(Pageable pageable, boolean b);

}