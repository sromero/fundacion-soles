package com.ues21.fundacionsoles.service;


import com.ues21.fundacionsoles.dto.LoginDto;
import com.ues21.fundacionsoles.dto.RegisterDto;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    @Transactional
    String login(LoginDto loginDto);

    @Transactional
    String register(RegisterDto registerDto);
}