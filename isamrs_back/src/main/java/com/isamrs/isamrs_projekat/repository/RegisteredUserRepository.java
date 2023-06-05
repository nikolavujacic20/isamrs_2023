package com.isamrs.isamrs_projekat.repository;

import com.isamrs.isamrs_projekat.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {


    RegisteredUser findByEmail(String email);

//     @Query(value = "SELECT * FROM USERS WHERE TYPE = 'registered_user' AND IS_ACTIVE = TRUE", nativeQuery = true)
    @Query(value = "SELECT * FROM USERS", nativeQuery = true)
    List<RegisteredUser> findAllRegisteredUser();

    Optional<RegisteredUser> findByIdAndIsActive(Long id, boolean b);

    RegisteredUser findByEmailAndIsActive(String email, boolean b);

}
