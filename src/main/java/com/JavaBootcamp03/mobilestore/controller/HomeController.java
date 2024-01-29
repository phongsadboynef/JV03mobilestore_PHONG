package com.JavaBootcamp03.mobilestore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
//@RequestMapping("/index")
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/product")
    public ModelAndView product() {
        return new ModelAndView("product");
    }
}