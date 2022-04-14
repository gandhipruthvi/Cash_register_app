package com.humber.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.humber.model.User;
import com.humber.service.UserService;
 
@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
     
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user) {
        User u = userService.login(user);
        if(u == null) {
            return "wrongcredentials"; 
        }
        return "redirect:/home";
    }

    
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

}