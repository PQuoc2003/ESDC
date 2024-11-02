package com.hyperion.lab06.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomepage(@AuthenticationPrincipal OAuth2User principal, Model model){

        String name = principal.getAttribute("login");
        String avatarUrl = principal.getAttribute("avatar_url");

        model.addAttribute("name", name);
        model.addAttribute("avatar", avatarUrl);

        return "homepage";
    }


    @RequestMapping("/user")
    public Principal user(Principal user){
        return  user;
    }
}
