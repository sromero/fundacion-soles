package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository < User, Long > {
    User findByEmail(String email);
}