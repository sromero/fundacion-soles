package com.ues21.fundacionsoles.service.impl;

import com.ues21.fundacionsoles.dto.LoginDto;
import com.ues21.fundacionsoles.dto.RegisterDto;
import com.ues21.fundacionsoles.exception.BaseException;
import com.ues21.fundacionsoles.model.Role;
import com.ues21.fundacionsoles.model.User;
import com.ues21.fundacionsoles.repository.RoleRepository;
import com.ues21.fundacionsoles.repository.UserRepository;
import com.ues21.fundacionsoles.security.JwtTokenProvider;
import com.ues21.fundacionsoles.service.AuthService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@Log4j2
@Service
public class AuthServiceImpl implements AuthService {

    private AuthService authService;

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication;

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword());

        try {
            authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (Exception e) {
            log.info("Invalid username or password!.", HttpStatus.BAD_REQUEST);
            throw new BaseException(HttpStatus.BAD_REQUEST, "Invalid username or password!.");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new BaseException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new BaseException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();

        try {
            Role userRole = roleRepository.findByName(registerDto.getRole()).get();
            roles.add(userRole);
        } catch (Exception e) {
            log.info("Role not found!.", HttpStatus.BAD_REQUEST);
            throw new BaseException(HttpStatus.BAD_REQUEST, "Role not found. Should be like ie role:ROLE_VOLUNTARIO");
        }

        user.setRoles(roles);
        userRepository.save(user);

        return "User registered successfully!.";
    }

}
