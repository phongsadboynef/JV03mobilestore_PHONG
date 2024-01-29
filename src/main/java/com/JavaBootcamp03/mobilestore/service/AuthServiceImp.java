//package com.JavaBootcamp03.mobilestore.service;
//
//import com.JavaBootcamp03.mobilestore.dto.CustomerDTO;
//import com.JavaBootcamp03.mobilestore.jwt.JwtTokenProvider;
//import com.JavaBootcamp03.mobilestore.service.serviceInterface.AuthService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class AuthServiceImp implements AuthService {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//    @Override
//    public String login(CustomerDTO customerDto) {
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                customerDto.getEmail(),
//                customerDto.getPassword()
//        ));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String token = jwtTokenProvider.generateToken(authentication);
//
//        return token;
//    }
//}
