package com.JavaBootcamp03.mobilestore.controller;


import com.JavaBootcamp03.mobilestore.dto.CustomerDTO;
import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;
import com.JavaBootcamp03.mobilestore.payload.response.ApiResponse;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.CustomerServiceImp;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.JavaBootcamp03.mobilestore.jwt.JwtHelper;

@CrossOrigin
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    CustomerServiceImp customerServiceImp;

    @Autowired
    private ModelMapper modelMapper;

    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(AuthenticationManager authenticationManager, JwtHelper jwtHelper,
                          CustomerServiceImp customerServiceImp) {
        this.authenticationManager = authenticationManager;
        this.jwtHelper = jwtHelper;
        this.customerServiceImp = customerServiceImp;
    }

    @GetMapping("")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String email, @RequestParam String password){
        logger.info("Request Email: " + email);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);

        Authentication authentication = authenticationManager.authenticate(token);
        String json = gson.toJson(authentication.getAuthorities());
        String jwtToken = jwtHelper.generateToken(json);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(jwtToken);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody CustomerDTO customerDTO){
        if(customerServiceImp.existsByEmail(customerDTO.getEmail())){
            logger.info("Check email exist");
            return new ResponseEntity<>(new ApiResponse(Boolean.FALSE, 400,
                    "Email is already taken!", ""),
                    HttpStatus.BAD_REQUEST);
        }

        CustomerEntity customer = customerServiceImp.signUpCustomer(customerDTO);

        CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);

        logger.info("Customer is created");

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(customerResponse);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

