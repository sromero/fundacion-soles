package com.ues21.fundacionsoles.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1")
public class MainController {

    @GetMapping("/test")
    public String testIndex(Model model) {
        System.out.println("llegamos al test");
        return "test";
    }
}
