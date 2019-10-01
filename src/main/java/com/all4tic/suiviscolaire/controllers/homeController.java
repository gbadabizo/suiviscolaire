package com.all4tic.suiviscolaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin 
public class homeController {
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "bonjour tous le monde";
        model.addAttribute("message", message);

        return "index";
    }
    @GetMapping("login")
    public String login() {
    	return"login";
    }
   
}
