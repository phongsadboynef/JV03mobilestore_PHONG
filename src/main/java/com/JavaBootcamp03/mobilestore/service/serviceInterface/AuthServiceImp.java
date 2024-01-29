package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.dto.CustomerDTO;
import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;
import com.JavaBootcamp03.mobilestore.entity.UserEntity;

public interface AuthServiceImp {
    CustomerEntity checkLogin(String email, String password);

//    UserEntity checkLoginAdmin(String email, String password);
}