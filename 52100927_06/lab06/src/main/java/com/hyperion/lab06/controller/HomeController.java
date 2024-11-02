package com.hyperion.lab06.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String getHomepage(){
        return "Login success";
    }


    @RequestMapping("/user")
    public Principal user(Principal user){
        return  user;
    }
}
