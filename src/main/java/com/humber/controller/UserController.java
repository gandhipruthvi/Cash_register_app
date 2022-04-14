package com.humber.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;	
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.humber.model.User;
import com.humber.service.UserService;
 
@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
     
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }
    
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        
    	userService.save(user);
        return "redirect:/login";
    }
}