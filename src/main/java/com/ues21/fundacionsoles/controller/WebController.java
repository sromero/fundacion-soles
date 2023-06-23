package com.ues21.fundacionsoles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    // handler method to handle home page request
    @RequestMapping("/web/flow/dashboard")
    public String home(){
        return "dashboard";
    }
}
