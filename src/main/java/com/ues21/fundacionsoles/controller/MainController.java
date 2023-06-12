package com.ues21.fundacionsoles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root(Model model) {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/test")
    public String testIndex(Model model) {
        return "dashboard";
    }
}
