package com.JavaBootcamp03.mobilestore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginTest")
public class LoginController {
    @GetMapping("")
    public String loginApp(){
        return "login to mobile store successfully!!!";
    }

}

