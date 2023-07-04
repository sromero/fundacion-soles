package com.ues21.fundacionsoles.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
}