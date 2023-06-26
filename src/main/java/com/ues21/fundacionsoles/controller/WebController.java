package com.ues21.fundacionsoles.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAnyRole('ROLE_COORDINADOR', 'ROLE_ADMINISTRADOR')")
public class WebController {

    // handler method to handle home page request
    @RequestMapping("/web/flow/dashboard")
    public String home(){
        return "dashboard";
    }
}
