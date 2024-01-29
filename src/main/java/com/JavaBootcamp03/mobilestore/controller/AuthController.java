package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.dto.CustomerDTO;
import com.JavaBootcamp03.mobilestore.dto.LoginDTO;
//import com.JavaBootcamp03.mobilestore.payload.response.JwtAuthResponse;
import com.JavaBootcamp03.mobilestore.repository.CustomerRepository;
import com.JavaBootcamp03.mobilestore.repository.RoleRepository;
//import com.JavaBootcamp03.mobilestore.service.serviceInterface.AuthService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class AuthController {

//    private AuthService authService;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;

//    private Gson gson = new Gson();
//    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

//    @PostMapping("/signin")
//    public ResponseEntity<JwtAuthResponse> login(@RequestBody CustomerDTO customerDto){
//        String token = authService.login(customerDto);
//
//        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
//        jwtAuthResponse.setAccessToken(token);
//        jwtAuthResponse.setTokenType("Bearer");
//        jwtAuthResponse.setEmail(customerDto.getEmail());
//        jwtAuthResponse.setPassword(customerDto.getPassword());
//
//        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
//    }
}

