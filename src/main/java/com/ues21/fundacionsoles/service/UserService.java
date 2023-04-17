package com.ues21.fundacionsoles.service;


import com.ues21.fundacionsoles.model.User;
import com.ues21.fundacionsoles.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

}
