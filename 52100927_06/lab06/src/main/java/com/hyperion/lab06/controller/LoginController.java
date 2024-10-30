package com.hyperion.lab06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/", "/login"})
    public String getLoginForm(){
        return  "index";
    }


}
